package game.controllers.impl;


import game.controllers.ResourceController;
import game.controllers.dto.ResourceDto;
import game.services.ResourceService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Path("/resource")
public class ResourceControllerImpl implements ResourceController {


    @Inject
    public ResourceService resourceService;

    @GET
    @Path("/list")
    public List<ResourceDto> getListOfResources(){
        List<ResourceDto> ResourcesList = resourceService.getListOfResources();
        Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, ResourcesList.toString());
        return ResourcesList;
    }

}
