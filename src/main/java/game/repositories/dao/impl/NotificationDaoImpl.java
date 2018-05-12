package game.repositories.dao.impl;

import game.repositories.dao.NotificationDao;
import game.repositories.dao.helpers.QueryHelper;
import game.repositories.entities.NotificationEntity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class NotificationDaoImpl implements NotificationDao {
    @Override
    public List<NotificationEntity> getListOfNotifications() {
        return new QueryHelper<List<NotificationEntity>>() {
            protected void executeQuery(Statement statement, Connection connection) throws SQLException {
                List<NotificationEntity> notifications = new LinkedList<>();
                ResultSet rs = statement.executeQuery("SELECT * FROM Notification");
                while(rs.next()) {
                    NotificationEntity notification = new NotificationEntity(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("description")
                    );
                    notifications.add(notification);
                }
                returnResult(notifications);
            }
        }.run();
    }
}
