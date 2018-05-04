package game.repositories.dao;

import game.repositories.entities.UpgradeProductEntity;

import java.util.Collection;

public interface UpgradeProductDao {
    Collection<UpgradeProductEntity> getListOfUpgradeProducts();
}
