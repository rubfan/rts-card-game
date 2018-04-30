package game.services.impl;

import game.controllers.dto.BuildingProductDto;
import game.repositories.dao.BuildingProductDao;
import game.services.BuildingProductService;

import javax.inject.Inject;
import java.util.LinkedList;
import java.util.List;

public class BuildingProductServiceImpl implements BuildingProductService {

    @Inject
    public BuildingProductDao buildingProductDao;

    @Override
    public List<BuildingProductDto> getListOfBuildingResources() {
            final List<BuildingProductDto> buildingProducts = new LinkedList<>();
            buildingProductDao.getListOfBuildingResources().forEach(buildingProductEntity -> {
                buildingProducts.add(new BuildingProductDto(){{
                    setBuildingId(buildingProductEntity.getBuildingId());
                    setResourceId(buildingProductEntity.getResourceId());
                    setNumberPerSec(buildingProductEntity.getNumberPerSec());
                }});
            });
            return buildingProducts;
    }
}
