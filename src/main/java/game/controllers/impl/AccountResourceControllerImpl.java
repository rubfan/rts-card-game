package game.controllers.impl;

import game.controllers.AccountResourceController;
import game.controllers.dto.AccountResourceDto;
import game.controllers.dto.AccountResourceQuantityDto;
import game.services.AccountResourceService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

@Path("/account")
public class AccountResourceControllerImpl implements AccountResourceController {

    @Inject
    AccountResourceService accountResourceService;

    @Override
    @GET
    @Path("{account_id}/resource/list")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<AccountResourceDto> getAccountResourcesList(@PathParam("account_id") Integer accountId) {
        List<AccountResourceDto> accountResourceList = accountResourceService.getListOfAccountResources(accountId);
        Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, accountResourceList.toString());
        return accountResourceList;
    }

    @Override
    @GET
    @Path("{account_id}/resourcePerMin/list")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<AccountResourceQuantityDto> getAccountResourcesQuantity(@PathParam("account_id") Integer accountId) {
        Date lastCalcTime = new Date(System.currentTimeMillis() - 1000);
        long currenTimetMillis = System.currentTimeMillis();
        long lastCalcTimeMillis = lastCalcTime.getTime();
        long deltaTimeMillis = currenTimetMillis - lastCalcTimeMillis;
        long deltaTimeSeconds = TimeUnit.MILLISECONDS.toSeconds(deltaTimeMillis);
        List<AccountResourceQuantityDto> accountResourceQuantity = accountResourceService.getAccountResourcesQuantity(accountId, deltaTimeSeconds);
        Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, accountResourceQuantity.toString());
        return accountResourceQuantity;
    }
}
