package game.services.impl;

import game.controllers.dto.*;
import game.repositories.dao.CardProductDao;
import game.repositories.entities.AccountBuildingEntity;
import game.repositories.entities.AccountResourceEntity;
import game.repositories.entities.AccountUpgradeEntity;
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
                setCard(cardDto);

                List<AccountBuildingDto> account1BuildingDtoList = new LinkedList<>();
                cardProductEntity.getP1buildingList().forEach(accountBuildingEntity -> {
                    setAccountBuildingDto(account1BuildingDtoList, accountBuildingEntity);
                });
                setP1buildingList(account1BuildingDtoList);

                List<AccountBuildingDto> account2BuildingDtoList = new LinkedList<>();
                cardProductEntity.getP2buildingList().forEach(accountBuildingEntity -> {
                    setAccountBuildingDto(account2BuildingDtoList, accountBuildingEntity);
                });
                setP2buildingList(account2BuildingDtoList);



                List<AccountResourceDto> account1ResourceDtoList = new LinkedList<>();
                cardProductEntity.getP1accountResourceList().forEach(accountResourceEntity -> {
                    setAccountResourceDto(account1ResourceDtoList, accountResourceEntity);
                });
                setP1accountResourceList(account1ResourceDtoList);

                List<AccountResourceDto> account2ResourceDtoList = new LinkedList<>();
                cardProductEntity.getP2accountResourceList().forEach(accountResourceEntity -> {
                    setAccountResourceDto(account2ResourceDtoList, accountResourceEntity);
                });
                setP2accountResourceList(account2ResourceDtoList);



                List<AccountUpgradeDto> account1UpgradeDtoList = new LinkedList<>();
                cardProductEntity.getP1accountUpgradeList().forEach(accountUpgradeEntity -> {
                    setAccountUpgradeDto(account1UpgradeDtoList, accountUpgradeEntity);
                });
                setP1accountUpgradeList(account1UpgradeDtoList);

                List<AccountUpgradeDto> account2UpgradeDtoList = new LinkedList<>();
                cardProductEntity.getP2accountUpgradeList().forEach(accountUpgradeEntity -> {
                    setAccountUpgradeDto(account2UpgradeDtoList, accountUpgradeEntity);
                });
                setP2accountUpgradeList(account2UpgradeDtoList);


                List<AccountBuildingDto> necessaryBuildingList = new LinkedList<>();
                cardProductEntity.getNecessaryBuildingList().forEach(accountBuildingEntity -> {
                    setAccountBuildingDto(necessaryBuildingList, accountBuildingEntity);
                });
                setNecessaryBuildingList(necessaryBuildingList);


                List<AccountUpgradeDto> necessaryAccountUpgradeLis = new LinkedList<>();
                cardProductEntity.getNecessaryAccountUpgradeList().forEach(accountUpgradeEntity -> {
                    setAccountUpgradeDto(necessaryAccountUpgradeLis, accountUpgradeEntity);
                });
                setNecessaryAccountUpgradeList(necessaryAccountUpgradeLis);
            }});
        });
        return cardProducts;
    }

    private void setAccountUpgradeDto(List<AccountUpgradeDto> accountUpgradeDtoList, AccountUpgradeEntity accountUpgradeEntity) {
        AccountUpgradeDto accountUpgradeDto = new AccountUpgradeDto();
        accountUpgradeDto.setAccountId(accountUpgradeEntity.getAccountId());
        accountUpgradeDto.setUpgradeId(accountUpgradeEntity.getUpgradeId());
        accountUpgradeDto.setQuantity(accountUpgradeEntity.getQuantity());
        accountUpgradeDtoList.add(accountUpgradeDto);
    }

    private void setAccountResourceDto(List<AccountResourceDto> accountResourceDtoList, AccountResourceEntity accountResourceEntity) {
        AccountResourceDto accountResourceDto = new AccountResourceDto();
        accountResourceDto.setAccountId(accountResourceEntity.getAccountId());
        accountResourceDto.setResourceId(accountResourceEntity.getResourceId());
        accountResourceDto.setQuantity(accountResourceEntity.getQuantity());
        accountResourceDtoList.add(accountResourceDto);
    }

    private void setAccountBuildingDto(List<AccountBuildingDto> accountBuildingDtoList, AccountBuildingEntity accountBuildingEntity) {
        AccountBuildingDto accountBuildingDto = new AccountBuildingDto();
        accountBuildingDto.setAccountId(accountBuildingEntity.getAccountId());
        accountBuildingDto.setBuildingId(accountBuildingEntity.getBuildingId());
        accountBuildingDto.setNumber(accountBuildingEntity.getNumber());
        accountBuildingDtoList.add(accountBuildingDto);
    }


}
