package game.controllers.impl;

import game.controllers.AccountNotificationController;
import game.controllers.dto.AccountNotificationDto;
import game.services.AccountNotificationService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Path("/account")

public class AccountNotificationControllerImpl implements AccountNotificationController {

    @Inject
    public AccountNotificationService accountNotificationService;

    @Override
    @GET
    @Path("/{account_id}/notification/list")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<AccountNotificationDto> getListOfAccountNotifications(@PathParam("account_id") Integer accountId) {
        List<AccountNotificationDto> accountNotificationList = accountNotificationService.getListOfAccountNotifications(accountId);
        Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, accountNotificationList.toString());
        return accountNotificationList;
    }

    @Override
    @GET
    @Path("/{account_id}/notification/all/clear")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response clearAccountNotificationList(@PathParam("account_id") Integer accountId) {
        accountNotificationService.clearAccountNotificationList(accountId);
        return Response.ok().build();
    }

    @Override
    @GET
    @Path("/{account_id}/notification/{notification_id}/add")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response addShownNotificationToAccount(@PathParam("account_id") Integer accountId,
                                              @PathParam("notification_id") Integer notificationId) {
        accountNotificationService.addShownNotificationToAccount(accountId, notificationId);
        return Response.status(201).entity("Notification").build();
    }
}
