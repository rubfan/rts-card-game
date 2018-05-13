package game.repositories.dao.impl;

import game.repositories.dao.AccountNotificationDao;
import game.repositories.dao.helpers.QueryHelper;
import game.repositories.entities.AccountNotificationEntity;

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
                            rs.getInt("id"),
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
//                } else {
//
//                    statement.executeUpdate("UPDATE Account_Building SET number = number + 1 " +
//                            "WHERE account_id = " + accountId + " AND building_id = " + notificationId);
//                }
            }
        }.run();
    }
}
