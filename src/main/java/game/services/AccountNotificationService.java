package game.services;

import game.controllers.dto.AccountNotificationDto;

import java.util.List;

public interface AccountNotificationService {
    List<AccountNotificationDto> getListOfAccountNotifications(int accountId);
    void clearAccountNotificationList(int accountId);
    void addShownNotificationToAccount(int accountId, int notificationId);
}
