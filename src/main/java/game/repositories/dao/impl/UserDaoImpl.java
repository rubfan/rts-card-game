package game.repositories.dao.impl;

import java.sql.Connection;
import game.repositories.dao.UserDao;
import game.repositories.dao.helpers.QueryHelper;
import game.repositories.entities.UserEntity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @autor ruslangramatic on 4/20/18.
 */
public class UserDaoImpl implements UserDao {
    @Override
    public String loginUser(UserEntity user) {
        return new QueryHelper<String>() {
            protected void executeQuery(Statement statement, Connection connection) throws SQLException {
                PreparedStatement pstmt = connection.prepareStatement(
                        "SELECT token FROM User WHERE name = ? and password = ?;");
                pstmt.setString(1, user.getName());
                pstmt.setString(2, user.getPassword());
                ResultSet rs = pstmt.executeQuery();
                if(rs.next()) {
                    setResult(rs.getString("token"));
                }
            }
        }.run();
    }

    @Override
    public void logoutUser(String token) {
        new QueryHelper() {
            protected void executeQuery(Statement statement, Connection connection) throws SQLException {
                // TODO: Updates Room where user was
            }
        }.run();
    }

    @Override
    public String createNewUser(UserEntity user) {
        new QueryHelper() {
            protected void executeQuery(Statement statement, Connection connection) throws SQLException {
                PreparedStatement pstmt = connection.prepareStatement(
                        "INSERT IGNORE INTO User (name, password, token) VALUES (?,?,?);");
                pstmt.setString(1, user.getName());
                pstmt.setString(2, user.getPassword());
                pstmt.setString(3, user.getToken());
                int status = pstmt.executeUpdate();
            }
        }.run();
        return user.getToken();
    }

    @Override
    public UserEntity getUserByToken(String token) {
        return new QueryHelper<UserEntity>() {
            protected void executeQuery(Statement statement, Connection connection) throws SQLException {
                PreparedStatement pstmt = connection.prepareStatement(
                        "SELECT id, name, token FROM User WHERE token = ?;");
                pstmt.setString(1, token);
                ResultSet rs = pstmt.executeQuery();
                if(rs.next()) {
                    setResult(new UserEntity(
                            rs.getInt("id"),
                            rs.getString("name"),
                            null,
                            rs.getString("token")
                    ));
                }
            }
        }.run();
    }


}

