package game.controllers.impl;


import game.controllers.ResourcesController;
import game.controllers.dto.ResourсesDto;
import game.services.ResourcesService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

<<<<<<< HEAD
@Path("/resources")
=======
@Path("/resource")
>>>>>>> f51361c04eafcd0a0918362d237cfad9254d7047
public class ResourcesControllerImpl implements ResourcesController{


    @Inject
    public ResourcesService resourceService;

    @GET
    @Path("/list")
    public List<ResourсesDto> getListOfResources(){
        List<ResourсesDto> ResourcesList = resourceService.getListOfResources();
        Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, ResourcesList.toString());
        return ResourcesList;
    }

}
