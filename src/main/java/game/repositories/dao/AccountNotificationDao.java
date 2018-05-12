package game.repositories.dao;

import game.repositories.entities.AccountNotificationEntity;

import java.util.List;

public interface AccountNotificationDao {
    List<AccountNotificationEntity> getListOfAccountNotifications(int accountId);
    void clearAccountNotificationList(int accountId);
    void addShownNotificationToAccount(int accountId, int notificationId);
}
