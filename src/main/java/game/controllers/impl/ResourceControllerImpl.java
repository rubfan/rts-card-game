package game.controllers.impl;


import game.controllers.ResourceController;
import game.controllers.dto.ResourсeDto;
import game.services.ResourceService;

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
<<<<<<< HEAD:src/main/java/game/controllers/impl/ResourcesControllerImpl.java
>>>>>>> f51361c04eafcd0a0918362d237cfad9254d7047
public class ResourcesControllerImpl implements ResourcesController{
=======
public class ResourceControllerImpl implements ResourceController {
>>>>>>> 07b3999f3ebe14f462141f2d600db736f993e516:src/main/java/game/controllers/impl/ResourceControllerImpl.java


    @Inject
    public ResourceService resourceService;

    @GET
    @Path("/list")
    public List<ResourсeDto> getListOfResources(){
        List<ResourсeDto> ResourcesList = resourceService.getListOfResources();
        Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, ResourcesList.toString());
        return ResourcesList;
    }

}
