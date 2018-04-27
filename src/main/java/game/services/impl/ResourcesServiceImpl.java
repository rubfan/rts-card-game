package game.services.impl;

import game.controllers.dto.ResourсesDto;
import game.repositories.dao.ResourcesDao;
import game.services.ResourcesService;

import javax.inject.Inject;
import java.util.LinkedList;
import java.util.List;

public class ResourcesServiceImpl implements ResourcesService {

    @Inject
    public ResourcesDao resourcesDao;

    public List<ResourсesDto> getListOfResources(){
<<<<<<< HEAD
        final List<ResourcesDto> resources = new LinkedList<>();
        resourcesDao.getListOfResources().forEach(resourcesEntity -> {
            resources.add(new ResourcesDto(){{
                setId(resourcesEntity.getId());
                setNumber( resourcesEntity.getNumber());
=======
        final List<ResourсesDto> resources = new LinkedList<>();
        resourcesDao.getListOfResources().forEach(resourcesEntity -> {
            resources.add(new ResourсesDto(){{
                setId(resourcesEntity.getId());
//                setNumber( resourcesEntity.getNumber());
>>>>>>> f51361c04eafcd0a0918362d237cfad9254d7047
                setName(resourcesEntity.getName());
                setDescription(resourcesEntity.getDescription());
            }});
        });
        return resources;
    }




}
