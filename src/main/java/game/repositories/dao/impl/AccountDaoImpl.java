package game.repositories.dao.impl;

import game.repositories.dao.AccountDao;
import game.repositories.dao.helpers.QueryHelper;
import game.repositories.entities.AccountEntity;
import game.repositories.entities.RoomEntity;
import game.repositories.entities.UserEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

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
    public void setRoomForAccount(AccountEntity account) {
        new QueryHelper() {
            protected void executeQuery(Statement statement, Connection connection) throws SQLException {
                PreparedStatement pstmt = connection.prepareStatement(
                        "UPDATE Account SET room_id=? WHERE user_id=?;");
                pstmt.setInt(1, account.getRoom_id());
                pstmt.setInt(2, account.getUser_id());
                int status = pstmt.executeUpdate();
            }
        }.run();
    }

    @Override
    public void deleteRoomFromAccount(AccountEntity account) {
        new QueryHelper() {
            protected void executeQuery(Statement statement, Connection connection) throws SQLException {
                PreparedStatement pstmt = connection.prepareStatement(
                        "UPDATE Account SET room_id=0 WHERE user_id=?;");
                pstmt.setInt(1, account.getUser_id());
                int status = pstmt.executeUpdate();
            }
        }.run();
    }
}
