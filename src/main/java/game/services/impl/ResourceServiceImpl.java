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

    public List<ResourсeDto> getListOfResources(){
        final List<ResourсeDto> resources = new LinkedList<>();
        resourcesDao.getListOfResources().forEach(resourcesEntity -> {
            resources.add(new ResourсeDto(){{
                setId(resourcesEntity.getId());
//                setNumber( resourcesEntity.getNumber());
                setName(resourcesEntity.getName());
                setDescription(resourcesEntity.getDescription());
            }});
        });
        return resources;
    }




}
