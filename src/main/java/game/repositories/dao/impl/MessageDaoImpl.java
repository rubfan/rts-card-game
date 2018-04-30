package game.repositories.dao.impl;

import game.repositories.dao.MessageDao;
import game.repositories.dao.helpers.QueryHelper;
import game.repositories.entities.MessageEntity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
                        rs.getInt("from_account_id"),
                        rs.getInt("to_account_id"),
                        rs.getDate("time")
                    );
                    messages.add(message);
                }
            }
        }.run();

        return messages;
    }
}
