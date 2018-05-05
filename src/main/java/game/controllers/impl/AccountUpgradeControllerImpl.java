package game.controllers.impl;


import game.controllers.AccountUpgradeController;
import game.controllers.dto.AccountUpgradeDto;
import game.services.AccountUpgradeService;

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
public class AccountUpgradeControllerImpl implements AccountUpgradeController {

    @Inject
    AccountUpgradeService accountUpgradeService;

    @Override
    @GET
    @Path("{account_id}/upgrade/list")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<AccountUpgradeDto> getAccountUpgradeList(@PathParam("account_id") Integer accountId) {
        List<AccountUpgradeDto> accountUpgradeList = accountUpgradeService.getListOfAccountUpgrades(accountId);
        Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, accountUpgradeList.toString());
        return accountUpgradeList;
    }
}
