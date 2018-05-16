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

    @Override
    public String getNotification(int notificationId) {
        return new QueryHelper<String>() {
            protected void executeQuery(Statement statement, Connection connection) throws SQLException {
                NotificationEntity notification = new NotificationEntity();
                ResultSet rs = statement.executeQuery("SELECT * FROM Notification WHERE id = " + notificationId);
                while(rs.next()) {
                    notification.setId(rs.getInt("id"));
                    notification.setName(rs.getString("name"));
                    notification.setDescription(rs.getString("description"));
                }
                returnResult(notification.getName());
            }
        }.run();
    }
}
