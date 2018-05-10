package game.controllers.impl;

import game.controllers.NotificationController;
import game.controllers.dto.NotificationDto;
import game.services.NotificationService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Path("/notification")
public class NotificationControllerImpl implements NotificationController {

    @Inject
    public NotificationService notificationService;

    @Override
    @GET
    @Path("list")
    public List<NotificationDto> getNotificationsList() {
        List<NotificationDto> notificationList = notificationService.getListOfNotifications();
        Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, notificationList.toString());
        return notificationList;
    }
}
