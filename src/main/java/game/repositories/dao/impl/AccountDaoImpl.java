package game.repositories.dao.impl;

import game.repositories.dao.AccountDao;
import game.repositories.dao.helpers.QueryHelper;
import game.repositories.entities.AccountEntity;
import game.repositories.entities.RoomEntity;
import game.repositories.entities.UserEntity;

import java.sql.*;

public class AccountDaoImpl implements AccountDao {

    @Override
    public void createAccount(AccountEntity account) {
        new QueryHelper() {
            protected void executeQuery(Statement statement, Connection connection) throws SQLException {
                PreparedStatement pstmt = connection.prepareStatement(
                        "INSERT IGNORE INTO Account (user_id) VALUES (?);");
                pstmt.setInt(1, account.getUser().getId());
                int status = pstmt.executeUpdate();
            }
        }.run();
    }

    @Override
    public void setRoomForAccount(Integer userId, Integer roomId) {
        new QueryHelper() {
            protected void executeQuery(Statement statement, Connection connection) throws SQLException {
                PreparedStatement pstmt = connection.prepareStatement(
                        "UPDATE Account SET room_id=? WHERE user_id=?;");
                pstmt.setInt(1, roomId);
                pstmt.setInt(2, userId);
                int status = pstmt.executeUpdate();
            }
        }.run();
    }

    @Override
    public void deleteRoomFromAccount(Integer userId) {
        new QueryHelper() {
            protected void executeQuery(Statement statement, Connection connection) throws SQLException {
                PreparedStatement pstmt = connection.prepareStatement(
                        "UPDATE Account SET room_id=NULL WHERE user_id=?;");
                pstmt.setInt(1, userId);
                int status = pstmt.executeUpdate();
            }
        }.run();
    }

    @Override
    public Integer getAccountIdByUserId(Integer userId) {
        return new QueryHelper<Integer>() {
            protected void executeQuery(Statement statement, Connection connection) throws SQLException {
                PreparedStatement pstmt = connection.prepareStatement(
                        "SELECT id FROM Account WHERE user_id = ?;");
                pstmt.setInt(1, userId);
                ResultSet rs = pstmt.executeQuery();

                if(rs.next()) {
                    setResult(rs.getInt("id"));
                }
            }
        }.run();
    }

    @Override
    public AccountEntity getAccountByUser(final UserEntity user) {
        return new QueryHelper<AccountEntity>() {
            protected void executeQuery(Statement statement, Connection connection) throws SQLException {
                PreparedStatement pstmt = connection.prepareStatement(
                        "SELECT a.id , a.room_id, r.name, r.description, r.start_game_time FROM Account a " +
                                "LEFT JOIN Room r ON r.id = a.room_id " +
                                "WHERE user_id = ?");
                pstmt.setInt(1, user.getId());
                ResultSet rs = pstmt.executeQuery();
                if(rs.next()) {
                    AccountEntity accountEntity = new AccountEntity();
                    accountEntity.setId(rs.getInt("id"));
                    if(rs.getInt("room_id") != 0) {
                        RoomEntity roomEntity = new RoomEntity();
                        roomEntity.setId(rs.getInt("room_id"));
                        roomEntity.setName(rs.getString("name"));
                        roomEntity.setDescription(rs.getString("description"));
                        roomEntity.setStart_game_time(rs.getDate("start_game_time"));
                        accountEntity.setRoom(roomEntity);
                    }
                    accountEntity.setUser(user);
                    setResult(accountEntity);
                }
            }
        }.run();
    }

}
