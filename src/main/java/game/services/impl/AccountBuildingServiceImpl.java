package game.services.impl;

import game.controllers.dto.AccountBuildingDto;
import game.repositories.dao.AccountBuildingDao;
import game.services.AccountBuildingService;

import javax.inject.Inject;
import java.util.LinkedList;
import java.util.List;

public class AccountBuildingServiceImpl implements AccountBuildingService {

    @Inject
    public AccountBuildingDao accountBuildingDao;

    @Override
    public List<AccountBuildingDto> getListOfAccountBuildings(int accountId) {
        final List<AccountBuildingDto> accountBuildings = new LinkedList<>();
        accountBuildingDao.getListOfAccountBuildings(accountId).forEach(accountBuildingEntity -> {
            accountBuildings.add(new AccountBuildingDto(){{
                setAccountId(accountBuildingEntity.getAccountId());
                setBuildingId(accountBuildingEntity.getBuildingId());
                setNumber(accountBuildingEntity.getNumber());
            }});
        });
        return accountBuildings;
    }
}
