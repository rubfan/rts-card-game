package game.services.impl;

import game.controllers.dto.AccountResourceDto;
import game.controllers.dto.AccountResourceQuantityDto;
import game.repositories.dao.AccountResourceDao;
import game.services.AccountResourceService;

import javax.inject.Inject;
import java.util.LinkedList;
import java.util.List;

public class AccountResourceServiceImpl implements AccountResourceService {

    @Inject
    AccountResourceDao accountResourceDao;

    @Override
    public List<AccountResourceDto> getListOfAccountResources(Integer accountId) {
        final List<AccountResourceDto> accountResources = new LinkedList<>();
        accountResourceDao.getListOfAccountResources(accountId).forEach(accountResourceEntity -> {
            accountResources.add(new AccountResourceDto() {{
                setAccountId(accountResourceEntity.getAccountId());
                setResourceId(accountResourceEntity.getResourceId());
                setQuantity(accountResourceEntity.getQuantity());
            }});
        });
        return accountResources;
    }

    @Override
    public List<AccountResourceQuantityDto> getAccountResourcesQuantity(Integer accountId, Long deltaTimeSeconds) {
        final List<AccountResourceQuantityDto> accountResourceQuantity = new LinkedList<>();
        accountResourceDao.getAccountResourcesQuantity(accountId, deltaTimeSeconds).forEach(accountResourceQuantityEntity -> {
            accountResourceQuantity.add(new AccountResourceQuantityDto() {{
                setResourceId(accountResourceQuantityEntity.getResourceId());
                setResourceNumber(accountResourceQuantityEntity.getResourceNumber());
                setResourcePerMIn(accountResourceQuantityEntity.getResourcePerMIn());
                setLastCalcTime(accountResourceQuantityEntity.getLastCalcTime());
            }});
        });
        return accountResourceQuantity;
    }
}
