package game.repositories.dao;

import game.repositories.entities.AccountBuildingEntity;

import java.util.List;

public interface AccountBuildingDao {
    List<AccountBuildingEntity> getListOfAccountBuildings(int accountId);
}
