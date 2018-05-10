package game.services.impl;

import game.controllers.dto.AccountUpgradeDto;
import game.repositories.dao.AccountUpgradeDao;
import game.repositories.entities.AccountUpgradeEntity;
import game.services.AccountUpgradeService;

import javax.inject.Inject;
import java.util.LinkedList;
import java.util.List;

public class AccountUpgradeServiceImpl implements AccountUpgradeService {

    @Inject
    AccountUpgradeDao accountUpgradeDao;

    @Override
    public List<AccountUpgradeDto> getListOfAccountUpgrades(Integer accountId) {
        final List<AccountUpgradeDto> accountUpgrades = new LinkedList<>();
        accountUpgradeDao.getListOfAccountUpgrades(accountId).forEach(accountUpgradeEntity -> {
        accountUpgrades.add(new AccountUpgradeDto(){{
            setAccountId(accountUpgradeEntity.getAccountId());
            setUpgradeId(accountUpgradeEntity.getUpgradeId());
            setQuantity(accountUpgradeEntity.getQuantity());
        }});
    });
        return accountUpgrades;
    }
}
