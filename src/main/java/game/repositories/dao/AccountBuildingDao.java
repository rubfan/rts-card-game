package game.repositories.dao;

import game.repositories.entities.AccountBuildingEntity;

import java.util.List;

public interface AccountBuildingDao {
    List<AccountBuildingEntity> getListOfAccountBuildings(int accountId);
    void clearAccountBuildingsList(int accountId);
    void addBuildingToAccount(int accountId, int buildingId);
}
