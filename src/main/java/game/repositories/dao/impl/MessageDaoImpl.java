package game.repositories.dao.impl;

import game.repositories.dao.MessageDao;
import game.repositories.dao.helpers.QueryHelper;
import game.repositories.entities.MessageEntity;
import game.repositories.entities.UserEntity;

import java.sql.*;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class MessageDaoImpl implements MessageDao {

    public List<MessageEntity> getListOfMessages() {
        return new QueryHelper<List<MessageEntity>>() {
            protected void executeQuery(Statement statement, Connection connection) throws SQLException {
                List<MessageEntity> messages = new LinkedList<>();
                ResultSet rs = statement.executeQuery("SELECT * FROM Message ORDER BY time");
                while(rs.next()) {
                    MessageEntity message = new MessageEntity(
                        rs.getInt("id"),
                        rs.getString("text"),
                        rs.getInt( "from_account_id"),
                        rs.getInt("to_account_id"),
                        rs.getTimestamp("time")
                    );
                    messages.add(message);
                }
                returnResult(messages);
            }
        }.run();
    }

    @Override
    public void sendMessage(String text, int fromAccountId, int toAccountId) {
        new QueryHelper() {
            protected void executeQuery(Statement statement, Connection connection) throws SQLException {
                PreparedStatement pstmt = connection.prepareStatement(
                        "INSERT INTO Message (text, from_account_id, to_account_id, time) VALUES (?,?,?,now());");
                pstmt.setString(1, text);
                pstmt.setInt(2, fromAccountId);
                pstmt.setInt(3, toAccountId);
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
                        "DELETE FROM `Message` WHERE `id` NOT IN (SELECT * FROM (SELECT `id` FROM `Message` WHERE `from_account_id` = ? ORDER BY `time` DESC LIMIT ?) AS `tmp1_table` )\n" +
                                "AND `id` NOT IN (SELECT * FROM (SELECT `id` FROM `Message` WHERE `from_account_id` != ?) AS `tmp2_table`);");
                pstmt.setInt(1, fromAccountId);
                pstmt.setInt(2, maxMessages);
                pstmt.setInt(3, fromAccountId);
                int status = pstmt.executeUpdate();
                connection.commit();
            }
        }.run();
    }

    @Override
    public List<MessageEntity> getRoomMessages(int fromAccountId, int toAccountId) {
        return new QueryHelper<List<MessageEntity>>() {
            protected void executeQuery(Statement statement, Connection connection) throws SQLException {
                List<MessageEntity> messages = new LinkedList<>();
                ResultSet rs = statement.executeQuery
                        ("SELECT * FROM Message WHERE from_account_id =" + fromAccountId +
                        " AND to_account_id =" + toAccountId + " ORDER BY time");
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
