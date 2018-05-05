package game.services.impl;

import game.controllers.dto.AccountResourceDto;
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
}
