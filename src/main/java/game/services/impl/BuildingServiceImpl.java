package game.services.impl;

import game.controllers.dto.BuildingDto;
import game.repositories.dao.BuildingDao;
import game.services.BuildingService;

import javax.inject.Inject;
import java.util.LinkedList;
import java.util.List;

public class BuildingServiceImpl implements BuildingService {

    @Inject
    public BuildingDao buildingDao;

    @Override
    public List<BuildingDto> getListOfBuildings() {
        final List<BuildingDto> buildings = new LinkedList<>();
        buildingDao.getListOfBuildings().forEach(buildingEntity -> {
            buildings.add(new BuildingDto(){{
                setId(buildingEntity.getId());
                setName(buildingEntity.getName());
                setDescription(buildingEntity.getDescription());
            }});
        });
        return buildings;
    }
}
