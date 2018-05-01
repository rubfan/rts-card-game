package game.repositories.dao;

import game.repositories.entities.UpgradeEntity;

import java.util.List;

public interface UpgradeDao {
    List<UpgradeEntity> getListOfUpgrades();
}
