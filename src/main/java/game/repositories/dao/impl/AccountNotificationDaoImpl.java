package game.repositories.dao.impl;

import game.repositories.dao.AccountNotificationDao;
import game.repositories.dao.helpers.QueryHelper;
import game.repositories.entities.AccountNotificationEntity;
import game.repositories.entities.NotificationEntity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class AccountNotificationDaoImpl implements AccountNotificationDao {

    @Override
    public List<AccountNotificationEntity> getListOfAccountNotifications(int accountId) {
        return new QueryHelper<List<AccountNotificationEntity>>() {
            protected void executeQuery(Statement statement, Connection connection) throws SQLException {
                List<AccountNotificationEntity> accountNotifications = new LinkedList<>();
                ResultSet rs = statement.executeQuery(
                        "SELECT * FROM Account_Notification WHERE account_id = " + accountId);
                while(rs.next()) {
                    AccountNotificationEntity accountNotification = new AccountNotificationEntity(
                           // rs.getInt("id"),
                            rs.getInt("account_id"),
                            rs.getInt("notification_id")
                    );
                    accountNotifications.add(accountNotification);
                }
                returnResult(accountNotifications);
            }
        }.run();
    }

    @Override
    public List<NotificationEntity> getListOfAccountRecentNotifications(int accountId) {
        return new QueryHelper<List<NotificationEntity>>() {
            protected void executeQuery(Statement statement, Connection connection) throws SQLException {
                List<NotificationEntity> recentNotifications = new LinkedList<>();
                ResultSet rs = statement.executeQuery(
                        "SELECT notification_id, name, description FROM\n" +
                                "  (SELECT Trigger_Notification.notification_id, name, description,\n" +
                                "                            building_id, building_number,\n" +
                                "                            resource_id, resource_number,\n" +
                                "                            upgrade_id, upgrade_number\n" +
                                "FROM\n" +
                                "  (SELECT Notification.id,name,description\n" +
                                "      FROM Notification LEFT JOIN\n" +
                                "        (SELECT * FROM Account_Notification WHERE account_id = " + accountId + ") AS account_shown\n" +
                                "        ON Notification.id = account_shown.notification_id\n" +
                                "        WHERE account_shown.notification_id IS NULL) AS account_unshown\n" +
                                "        LEFT JOIN Trigger_Notification\n" +
                                "        ON account_unshown.id = Trigger_Notification.notification_id) as to_check\n" +
                                "WHERE (to_check.building_number <= (SELECT number FROM Account_Building WHERE account_id = " + accountId + " AND building_id = to_check.building_id))\n" +
                                "AND (to_check.resource_number <= (SELECT number FROM Account_Resource WHERE account_id = " + accountId + " AND resource_id = to_check.resource_id))\n" +
                                "AND (to_check.upgrade_number <= (SELECT number FROM Account_Upgrade WHERE account_id = " + accountId + " AND upgrade_id = to_check.upgrade_id))");
                while(rs.next()) {
                    NotificationEntity recentNotification = new NotificationEntity(
                            rs.getInt("notification_id"),
                            rs.getString("name"),
                            rs.getString("description")
                    );
                    recentNotifications.add(recentNotification);
                }
                returnResult(recentNotifications);
            }
        }.run();
    }

    @Override
    public void clearAccountNotificationList(int accountId) {
        new QueryHelper() {
            protected void executeQuery(Statement statement, Connection connection) throws SQLException {
                statement.executeUpdate("DELETE FROM Account_Notification WHERE account_id = " + accountId);
                connection.commit();
            }
        }.run();
    }

    @Override
    public void addShownNotificationToAccount(int accountId, int notificationId) {
        new QueryHelper() {
            protected void executeQuery(Statement statement, Connection connection) throws SQLException {

                if (!statement.executeQuery("SELECT * FROM Account_Notification WHERE account_id = " +
                        accountId + " AND notification_id = " + notificationId).next()) {
                    statement.executeUpdate("INSERT INTO Account_Notification " +
                            "(account_id, notification_id)" +
                            "VALUES (" + accountId + "," + notificationId + ")");
                    connection.commit();
                }
            }
        }.run();
    }
}
