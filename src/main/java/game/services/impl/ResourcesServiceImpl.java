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
        final List<ResourcesDto> resources = new LinkedList<>();
        resourcesDao.getListOfResources().forEach(resourcesEntity -> {
            resources.add(new ResourcesDto(){{
                setId(resourcesEntity.getId());
                setNumber( resourcesEntity.getNumber());
                setName(resourcesEntity.getName());
                setDescription(resourcesEntity.getDescription());
            }});
        });
        return resources;
    }




}
