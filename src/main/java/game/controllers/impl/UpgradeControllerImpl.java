package game.controllers.impl;

import game.controllers.UpgradeController;
import game.controllers.dto.UpgradeDto;
import game.services.UpgradeService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Path("/update")
public class UpgradeControllerImpl implements UpgradeController {

    @Inject
    public UpgradeService upgradeService;

    @GET
    @Path("list")
    public List<UpgradeDto> getUpgradeList() {
        List<UpgradeDto> cardList = upgradeService.getListOfUpgrades();
        Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, cardList.toString());
        return cardList;
    }
}
