package game.controllers;

import game.controllers.dto.NotificationDto;

import java.util.List;

public interface NotificationController {

    List<NotificationDto> getNotificationsList();
    String getNotification(Integer notificationId);
}
