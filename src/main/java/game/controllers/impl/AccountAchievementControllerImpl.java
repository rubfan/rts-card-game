package game.controllers.impl;

import game.controllers.AccountAchievementController;
import game.controllers.dto.AccountAchievementDto;
import game.services.AccountAchievementService;

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
public class AccountAchievementControllerImpl implements AccountAchievementController {
    @Inject
    public AccountAchievementService accountAchievementService;

    @Override
    @GET
    @Path("/{account_id}/achievement/list")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<AccountAchievementDto> getAccountAchievementsList(@PathParam("account_id") Integer accountId) {
        List<AccountAchievementDto> accountAchievementList = accountAchievementService.getListOfAccountAchievements(accountId);
        Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, accountAchievementList.toString());
        return accountAchievementList;
    }

    @Override
    @GET
    @Path("/{account_id}/achievement/all/clear")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response clearAccountAchievementsList(@PathParam("account_id") Integer accountId) {
        accountAchievementService.clearAccountAchievementsList(accountId);
        return Response.ok().build();
    }

    @Override
    @GET
    @Path("/{account_id}/achievement/{achievement_id}/add")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response addAchievementToAccount(@PathParam("account_id") Integer accountId, @PathParam("achievement_id") Integer achievementId) {
        accountAchievementService.addAchievementToAccount(accountId,achievementId);
        return Response.status(201).entity("Achievement").build();
    }
}
