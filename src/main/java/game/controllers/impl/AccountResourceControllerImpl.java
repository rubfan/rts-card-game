package game.controllers.impl;

import game.controllers.AccountResourceController;
import game.controllers.dto.AccountResourceDto;
import game.services.AccountResourceService;

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
}
