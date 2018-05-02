package game.services.impl;

import game.controllers.dto.ResourсeDto;
import game.repositories.dao.ResourceDao;
import game.services.ResourceService;

import javax.inject.Inject;
import java.util.LinkedList;
import java.util.List;

public class ResourceServiceImpl implements ResourceService {

    @Inject
    public ResourceDao resourcesDao;

<<<<<<< HEAD:src/main/java/game/services/impl/ResourcesServiceImpl.java
    public List<ResourсesDto> getListOfResources(){
<<<<<<< HEAD
        final List<ResourcesDto> resources = new LinkedList<>();
        resourcesDao.getListOfResources().forEach(resourcesEntity -> {
            resources.add(new ResourcesDto(){{
                setId(resourcesEntity.getId());
                setNumber( resourcesEntity.getNumber());
=======
        final List<ResourсesDto> resources = new LinkedList<>();
=======
    public List<ResourсeDto> getListOfResources(){
        final List<ResourсeDto> resources = new LinkedList<>();
>>>>>>> 07b3999f3ebe14f462141f2d600db736f993e516:src/main/java/game/services/impl/ResourceServiceImpl.java
        resourcesDao.getListOfResources().forEach(resourcesEntity -> {
            resources.add(new ResourсeDto(){{
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
