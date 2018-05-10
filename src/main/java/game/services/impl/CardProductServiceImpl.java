package game.services.impl;

import game.controllers.dto.*;
import game.repositories.dao.CardProductDao;
import game.repositories.entities.BuildingQuantityEntity;
import game.repositories.entities.ResourceQuantityEntity;
import game.repositories.entities.UpgradeQuantityEntity;
import game.services.CardProductService;

import javax.inject.Inject;
import java.util.LinkedList;
import java.util.List;

public class CardProductServiceImpl implements CardProductService {

    @Inject
    CardProductDao cardProductDao;

    @Override
    public List<CardProductDto> getListOfCardProducts() {
        final List<CardProductDto> cardProducts = new LinkedList<>();
        cardProductDao.getListOfCardProducts().forEach(cardProductEntity -> {
            cardProducts.add(new CardProductDto(){{
                setId(cardProductEntity.getId());

                CardDto cardDto = new CardDto();
                cardDto.setId(cardProductEntity.getCardEntity().getId());
                cardDto.setName(cardProductEntity.getCardEntity().getName());
                cardDto.setDescription(cardProductEntity.getCardEntity().getDescription());
                setCardDto(cardDto);

                List<BuildingQuantityDto> p1BuildingQuantityDtoList = new LinkedList<>();
                cardProductEntity.getP1BuildingQuantityEntityList().forEach(buildingQuantityEntity -> {
                    setBuildingQuantityDto(p1BuildingQuantityDtoList, buildingQuantityEntity);
                });
                setP1BuildingQuantityDtoList(p1BuildingQuantityDtoList);

                List<BuildingQuantityDto> p2BuildingQuantityDtoList = new LinkedList<>();
                cardProductEntity.getP2BuildingQuantityEntityList().forEach(buildingQuantityEntity -> {
                    setBuildingQuantityDto(p2BuildingQuantityDtoList, buildingQuantityEntity);
                });
                setP2BuildingQuantityDtoList(p2BuildingQuantityDtoList);



                List<ResourceQuantityDto> p1resourceQuantityDtoList = new LinkedList<>();
                cardProductEntity.getP1ResourceQuantityEntityList().forEach(resourceQuantityEntity -> {
                    setResourceQuantityDto(p1resourceQuantityDtoList, resourceQuantityEntity);
                });
                setP1ResourceQuantityDtoList(p1resourceQuantityDtoList);

                List<ResourceQuantityDto> p2resourceQuantityDtoList = new LinkedList<>();
                cardProductEntity.getP2ResourceQuantityEntityList().forEach(resourceQuantityEntity -> {
                    setResourceQuantityDto(p2resourceQuantityDtoList, resourceQuantityEntity);
                });
                setP2ResourceQuantityDtoList(p2resourceQuantityDtoList);



                List<UpgradeQuantityDto> p1UpgradeQuantityDtoList = new LinkedList<>();
                cardProductEntity.getP1UpgradeQuantityEntityList().forEach(upgradeQuantityEntity ->  {
                    setUpgradeQuantityDto(p1UpgradeQuantityDtoList, upgradeQuantityEntity);
                });
                setP1UpgradeQuantityDtoList(p1UpgradeQuantityDtoList);

                List<UpgradeQuantityDto> p2UpgradeQuantityDtoList = new LinkedList<>();
                cardProductEntity.getP2UpgradeQuantityEntityList().forEach(upgradeQuantityEntity ->  {
                    setUpgradeQuantityDto(p2UpgradeQuantityDtoList, upgradeQuantityEntity);
                });
                setP2UpgradeQuantityDtoList(p2UpgradeQuantityDtoList);


                List<BuildingQuantityDto> necessaryBuildingList = new LinkedList<>();
                cardProductEntity.getNecessaryBuildingQuantityEntityList().forEach(necessaryBuildingEntity -> {
                    setBuildingQuantityDto(necessaryBuildingList, necessaryBuildingEntity);
                });
                setNecessaryBuildingQuantityDtoList(necessaryBuildingList);


                List<UpgradeQuantityDto> necessaryUpgradeList = new LinkedList<>();
                cardProductEntity.getNecessaryUpgradeQuantityEntityList().forEach(necessaryUpgradeEntity -> {
                    setUpgradeQuantityDto(necessaryUpgradeList, necessaryUpgradeEntity);
                });
                setNecessaryUpgradeQuantityDtoList(necessaryUpgradeList);
            }});
        });
        return cardProducts;
    }

    private void setResourceQuantityDto(List<ResourceQuantityDto> resourceQuantityDtoList, ResourceQuantityEntity resourceQuantityEntity) {
        ResourceQuantityDto resourceQuantityDto = new ResourceQuantityDto();
        resourceQuantityDto.setId(resourceQuantityEntity.getId());
        resourceQuantityDto.setName(resourceQuantityEntity.getName());
        resourceQuantityDto.setDescription(resourceQuantityEntity.getDescription());
        resourceQuantityDto.setQuantity(resourceQuantityEntity.getQuantity());
        resourceQuantityDtoList.add(resourceQuantityDto);
    }

    private void setUpgradeQuantityDto(List<UpgradeQuantityDto> upgradeQuantityDtoList, UpgradeQuantityEntity upgradeQuantityEntity) {
        UpgradeQuantityDto upgradeQuantityDto = new UpgradeQuantityDto();
        upgradeQuantityDto.setId(upgradeQuantityEntity.getId());
        upgradeQuantityDto.setName(upgradeQuantityEntity.getName());
        upgradeQuantityDto.setDescription(upgradeQuantityEntity.getDescription());
        upgradeQuantityDto.setQuantity(upgradeQuantityEntity.getQuantity());
        upgradeQuantityDtoList.add(upgradeQuantityDto);
    }

    private void setBuildingQuantityDto(List<BuildingQuantityDto> buildingQuantityDtoList, BuildingQuantityEntity buildingQuantityEntity) {
        BuildingQuantityDto buildingQuantityDto = new BuildingQuantityDto();
        buildingQuantityDto.setId(buildingQuantityEntity.getId());
        buildingQuantityDto.setName(buildingQuantityEntity.getName());
        buildingQuantityDto.setDescription(buildingQuantityEntity.getDescription());
        buildingQuantityDto.setQuantity(buildingQuantityEntity.getQuantity());
        buildingQuantityDtoList.add(buildingQuantityDto);
    }


}
