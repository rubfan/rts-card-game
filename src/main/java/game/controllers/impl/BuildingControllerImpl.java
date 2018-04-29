package game.controllers.impl;

import game.controllers.BuildingController;
import game.controllers.dto.BuildingDto;
import game.services.BuildingService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Path("/building")
public class BuildingControllerImpl implements BuildingController {

    @Inject
    public BuildingService buildingService;

    @Override
    @GET
    @Path("list")
    public List<BuildingDto> getBuildingList() {
        List<BuildingDto> buildingList = buildingService.getListOfBuildings();
        Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, buildingList.toString());
        return buildingList;
    }
}
