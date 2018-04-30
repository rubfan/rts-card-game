package game.controllers.impl;

import game.controllers.AccountBuildingController;
import game.controllers.dto.AccountBuildingDto;
import game.services.AccountBuildingService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Path("/account")
public class AccountBuildingControllerImpl implements AccountBuildingController {

    @Inject
    public AccountBuildingService accountBuildingService;

    @Override
    @GET
    @Path("{account_id}/building/list")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<AccountBuildingDto> getAccountBuildingsList(@PathParam("account_id") Integer accountId) {
        List<AccountBuildingDto> accountBuildingList = accountBuildingService.getListOfAccountBuildings(accountId);
        Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, accountBuildingList.toString());
        return accountBuildingList;
    }
}
