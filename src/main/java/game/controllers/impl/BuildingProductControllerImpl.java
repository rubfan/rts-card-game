package game.controllers.impl;

import game.controllers.BuildingProductController;
import game.controllers.dto.BuildingProductDto;
import game.services.BuildingProductService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Path("/building")
public class BuildingProductControllerImpl implements BuildingProductController {

    @Inject
    public BuildingProductService buildingProductService;

    @Override
    @GET
    @Path("product_list")
    public List<BuildingProductDto> getBuildingResourcesList() {
        List<BuildingProductDto> buildingProductList = buildingProductService.getListOfBuildingResources();
        Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, buildingProductList.toString());
        return buildingProductList;
    }
}
