package game.services.impl;

import game.controllers.dto.AccountNotificationDto;
import game.controllers.dto.NotificationDto;
import game.repositories.dao.AccountNotificationDao;
import game.services.AccountNotificationService;

import javax.inject.Inject;
import java.util.LinkedList;
import java.util.List;

public class AccountNotificationServiceImpl implements AccountNotificationService {

    @Inject
    public AccountNotificationDao accountNotificationDao;

    @Override
    public List<AccountNotificationDto> getListOfAccountNotifications(int accountId) {
        final List<AccountNotificationDto> accountNotifications = new LinkedList<>();
        accountNotificationDao.getListOfAccountNotifications(accountId).forEach(accountNotificationEntity -> {
            accountNotifications.add(new AccountNotificationDto(){{
                setAccountId(accountNotificationEntity.getAccountId());
                setNotificationId(accountNotificationEntity.getNotificationId());
            }});
        });
        return accountNotifications;
    }

    @Override
    public void clearAccountNotificationList(int accountId) {
        accountNotificationDao.clearAccountNotificationList(accountId);
    }

    @Override
    public void addShownNotificationToAccount(int accountId, int notificationId) {
        accountNotificationDao.addShownNotificationToAccount(accountId, notificationId);
    }

    @Override
    public List<NotificationDto> getListOfAccountRecentNotification(int accountId) {
        final List<NotificationDto> recentNotifications = new LinkedList<>();
        accountNotificationDao.getListOfAccountRecentNotifications(accountId).forEach(recentNotificationEntity -> {
            recentNotifications.add(new NotificationDto(){{
                setId(recentNotificationEntity.getId());
                setName(recentNotificationEntity.getName());
                setDescription(recentNotificationEntity.getDescription());
            }});
        });

        recentNotifications.forEach(recentNotificationEntity -> {
            accountNotificationDao.addShownNotificationToAccount(accountId, recentNotificationEntity.getId());
        });

        return recentNotifications;
    }
}
