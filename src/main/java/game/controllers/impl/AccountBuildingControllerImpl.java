package game.controllers.impl;

import game.controllers.AccountBuildingController;
import game.controllers.dto.AccountBuildingDto;
import game.services.AccountBuildingService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Path("/account")
public class AccountBuildingControllerImpl implements AccountBuildingController {

    @Inject
    public AccountBuildingService accountBuildingService;

    @Override
    @GET
    @Path("/{account_id}/building/list")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<AccountBuildingDto> getAccountBuildingsList(@PathParam("account_id") Integer accountId) {
        List<AccountBuildingDto> accountBuildingList = accountBuildingService.getListOfAccountBuildings(accountId);
        Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, accountBuildingList.toString());
        return accountBuildingList;
    }

    //TODO: change to DELETE
    @Override
    @GET
    @Path("/{account_id}/building/all/clear")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response clearAccountBuildingsList(@PathParam("account_id") Integer accountId) {
        accountBuildingService.clearAccountBuildingsList(accountId);
        return Response.ok().build();
    }

    //TODO: change to PUT
    @Override
    @GET
    @Path("/{account_id}/building/{building_id}/add")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response addBuildingToAccount(@PathParam("account_id") Integer accountId, @PathParam("building_id") Integer buildingId) {
        accountBuildingService.addBuildingToAccount(accountId,buildingId);
        return Response.status(201).entity("Building").build();
    }
}
