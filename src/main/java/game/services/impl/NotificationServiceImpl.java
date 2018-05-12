package game.services.impl;

import game.controllers.dto.NotificationDto;
import game.repositories.dao.NotificationDao;
import game.services.NotificationService;

import javax.inject.Inject;
import java.util.LinkedList;
import java.util.List;

public class NotificationServiceImpl implements NotificationService {

    @Inject
    public NotificationDao notificationDao;

    @Override
    public List<NotificationDto> getListOfNotifications() {
        final List<NotificationDto> notifications = new LinkedList<>();
        notificationDao.getListOfNotifications().forEach(notificationEntity -> {
            notifications.add(new NotificationDto(){{
                setId(notificationEntity.getId());
                setName(notificationEntity.getName());
                setDescription(notificationEntity.getDescription());
            }});
        });
        return notifications;
    }
}
