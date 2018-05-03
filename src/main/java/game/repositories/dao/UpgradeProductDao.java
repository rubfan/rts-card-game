package game.repositories.dao;

import game.repositories.entities.UpgradeProductEntity;

import java.util.List;

public interface UpgradeProductDao {
    List<UpgradeProductEntity> getListOfUpgradeResources();
}
