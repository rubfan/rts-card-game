package game.services.impl;

import game.controllers.dto.*;
import game.repositories.dao.UpgradeProductDao;
import game.services.UpgradeProductService;

import javax.inject.Inject;
import java.util.LinkedList;
import java.util.List;

public class UpgradeProductServiceImpl implements UpgradeProductService {

    @Inject
    UpgradeProductDao upgradeProductDao;

    @Override
    public List<UpgradeProductDto> getListOfUpgradeProducts() {
        final List<UpgradeProductDto> upgradeProducts = new LinkedList<>();
        upgradeProductDao.getListOfUpgradeProducts().forEach(upgradeProductEntity -> {
            upgradeProducts.add(new UpgradeProductDto(){{
                setId(upgradeProductEntity.getId());

                UpgradeDto upgradeDto = new UpgradeDto();
                upgradeDto.setId(upgradeProductEntity.getUpgradeEntity().getId());
                upgradeDto.setName(upgradeProductEntity.getUpgradeEntity().getName());
                upgradeDto.setDescription(upgradeProductEntity.getUpgradeEntity().getDescription());
                setUpgradeDto(upgradeDto);

                List<BuildingDto> buildingDtoList = new LinkedList<>();
                upgradeProductEntity.getBuildingEntityList().forEach(buildingEntity -> {
                    BuildingDto buildingDto = new BuildingDto();
                    buildingDto.setId(buildingEntity.getId());
                    buildingDto.setName(buildingEntity.getName());
                    buildingDto.setDescription(buildingEntity.getDescription());
                    buildingDtoList.add(buildingDto);
                });
                setBuildingDtoList(buildingDtoList);

                List<ResourceQuantityDto> resourceQuantityDtoList = new LinkedList<>();
                upgradeProductEntity.getResourceEntityList().forEach(resourceQuantityEntity -> {
                    ResourceQuantityDto resourceQuantityDto = new ResourceQuantityDto();
                    resourceQuantityDto.setId(resourceQuantityEntity.getId());
                    resourceQuantityDto.setName(resourceQuantityEntity.getName());
                    resourceQuantityDto.setDescription(resourceQuantityEntity.getDescription());
                    resourceQuantityDto.setQuantity(resourceQuantityEntity.getQuantity());
                    resourceQuantityDtoList.add(resourceQuantityDto);
                });
                setResourceQuantityDtoList(resourceQuantityDtoList);
            }});
        });
        return upgradeProducts;
    }

}
