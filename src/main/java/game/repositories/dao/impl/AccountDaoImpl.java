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
                pstmt.setInt(1, account.getUser_id());
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

}
