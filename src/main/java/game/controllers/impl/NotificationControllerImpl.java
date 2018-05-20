package game.controllers.impl;

import game.controllers.NotificationController;
import game.controllers.dto.NotificationDto;
import game.services.NotificationService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
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

    @Override
    @GET
    @Path("{notification_id}/get")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public String getNotification(@PathParam("notification_id") Integer notificationId) {
       // NotificationDto notification = notificationService.getNotification(notificationId);
      //  Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, notification.toString());
        return notificationService.getNotification(notificationId);
    }
}
