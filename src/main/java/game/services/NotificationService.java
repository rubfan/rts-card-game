package game.services;

import game.controllers.dto.NotificationDto;

import java.util.List;

public interface NotificationService {
    List<NotificationDto> getListOfNotifications();
}
