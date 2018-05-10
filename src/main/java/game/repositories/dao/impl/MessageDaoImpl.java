package game.repositories.dao.impl;

import game.repositories.dao.MessageDao;
import game.repositories.dao.helpers.QueryHelper;
import game.repositories.entities.MessageEntity;

import java.sql.*;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class MessageDaoImpl implements MessageDao {

    public List<MessageEntity> getListOfMessages() {
        final List<MessageEntity> messages = new LinkedList<MessageEntity>();

        new QueryHelper() {
            protected void executeQuery(Statement statement, Connection connection) throws SQLException {
                statement.executeUpdate("use card_battle_rts");
                ResultSet rs = statement.executeQuery("select * from Message");
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
            }
        }.run();

        return messages;
    }

    @Override
    public void sendMessage(String text, Integer from_account_id, Integer to_account_id) {
        new QueryHelper() {
            protected void executeQuery(Statement statement, Connection connection) throws SQLException {
                PreparedStatement pstmt = connection.prepareStatement(
                        "INSERT INTO Message (text, from_account_id, to_account_id, time) VALUES (?,?,?,?);");
                pstmt.setString(1, text);
                pstmt.setInt(2, from_account_id);
                pstmt.setInt(3, to_account_id);
                pstmt.setString(4, new Date().toString());
                int status = pstmt.executeUpdate();
            }
        }.run();
    }

    @Override
    public void getMessage() { }
}
