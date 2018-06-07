package game.repositories.dao;

import game.repositories.entities.AccountUpgradeEntity;

import java.util.List;

public interface AccountUpgradeDao {
    List<AccountUpgradeEntity> getListOfAccountUpgrades(int accountId);
    void cleanAccountUpgrade(int accountId);
}
