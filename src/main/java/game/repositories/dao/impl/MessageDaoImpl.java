package game.repositories.dao.impl;

import game.repositories.dao.MessageDao;
import game.repositories.dao.helpers.QueryHelper;
import game.repositories.entities.MessageEntity;
import game.repositories.entities.UserEntity;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class MessageDaoImpl implements MessageDao {

    public List<MessageEntity> getListOfMessages() {
        return new QueryHelper<List<MessageEntity>>() {
            protected void executeQuery(Statement statement, Connection connection) throws SQLException {
                List<MessageEntity> messages = new LinkedList<>();
                ResultSet rs = statement.executeQuery("SELECT * FROM Message");
                while(rs.next()) {
                    MessageEntity message = new MessageEntity(
                        rs.getInt("id"),
                        rs.getString("text"),
                        rs.getInt( "from_account_id"),
                        rs.getInt("to_account_id"),
                        rs.getDate("time")
                    );
                    messages.add(message);
                }
                returnResult(messages);
            }
        }.run();
    }

    @Override
    public void sendMessage(String text, int fromAccountId, int toAccountId, String time) {
        new QueryHelper() {
            protected void executeQuery(Statement statement, Connection connection) throws SQLException {
                PreparedStatement pstmt = connection.prepareStatement(
                        "INSERT INTO Message (text, from_account_id, to_account_id, time) VALUES (?,?,?,?);");
                pstmt.setString(1, text);
                pstmt.setInt(2, fromAccountId);
                pstmt.setInt(3, toAccountId);
                pstmt.setString(4, time);
                int status = pstmt.executeUpdate();
                connection.commit();
            }
        }.run();
    }

    @Override
    public void removeAboveLimit(int maxMessages, int fromAccountId) {
        new QueryHelper<UserEntity>() {
            protected void executeQuery(Statement statement, Connection connection) throws SQLException {
                PreparedStatement pstmt = connection.prepareStatement(
                        "DELETE FROM Message WHERE id NOT IN (SELECT id FROM Message WHERE from_account_id=? ORDER BY time DESC LIMIT ?) AND id NOT IN (SELECT id FROM Message WHERE NOT from_account_id=?)");
                pstmt.setInt(1, fromAccountId);
                pstmt.setInt(2, maxMessages);
                pstmt.setInt(3, fromAccountId);
                int status = pstmt.executeUpdate();
                connection.commit();
            }
        }.run();
    }

    @Override
    public List<MessageEntity> getMessages(int fromAccountId, int toAccountId) {
        return new QueryHelper<List<MessageEntity>>() {
            protected void executeQuery(Statement statement, Connection connection) throws SQLException {
                List<MessageEntity> messages = new LinkedList<>();
                ResultSet rs = statement.executeQuery
                        ("SELECT * FROM Message WHERE from_account_id=" + fromAccountId +
                        " AND to_account_id=" + toAccountId);
                while(rs.next()) {
                    MessageEntity message = new MessageEntity(
                            rs.getInt("id"),
                            rs.getString("text"),
                            rs.getInt( "from_account_id"),
                            rs.getInt("to_account_id"),
                            rs.getDate("time")
                    );
                    messages.add(message);
                }
                returnResult(messages);
            }
        }.run();
    }
}
