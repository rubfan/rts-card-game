package game.repositories.dao;

import game.repositories.entities.NotificationEntity;

import java.util.List;

public interface NotificationDao {
    List<NotificationEntity> getListOfNotifications();
}
