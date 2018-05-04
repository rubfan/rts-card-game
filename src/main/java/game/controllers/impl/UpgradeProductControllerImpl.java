package game.controllers.impl;

import game.controllers.UpgradeProductController;
import game.controllers.dto.UpgradeProductDto;
import game.services.UpgradeProductService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Path("/upgrade")
public class UpgradeProductControllerImpl implements UpgradeProductController {

    @Inject
    public UpgradeProductService upgradeProductService;

    @GET
    @Path("product/list")
    public List<UpgradeProductDto> getListOfUpgradeProducts() {
        List<UpgradeProductDto> upgradeProductDtoList = upgradeProductService.getListOfUpgradeProducts();
        Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, upgradeProductDtoList.toString());
        return upgradeProductDtoList;
    }
}
