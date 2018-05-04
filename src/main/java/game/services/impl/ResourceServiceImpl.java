package game.services.impl;

import game.controllers.dto.ResourceDto;
import game.repositories.dao.ResourceDao;
import game.services.ResourceService;

import javax.inject.Inject;
import java.util.LinkedList;
import java.util.List;

public class ResourceServiceImpl implements ResourceService {

    @Inject
    public ResourceDao resourcesDao;

    public List<ResourceDto> getListOfResources(){
        final List<ResourceDto> resources = new LinkedList<>();
        resourcesDao.getListOfResources().forEach(resourcesEntity -> {
            resources.add(new ResourceDto(){{
                setId(resourcesEntity.getId());
                setName(resourcesEntity.getName());
                setDescription(resourcesEntity.getDescription());
            }});
        });
        return resources;
    }




}
