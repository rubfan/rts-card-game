package game.repositories.dao;

import game.repositories.entities.AccountResourceEntity;
import game.repositories.entities.AccountResourceQuantityEntity;

import java.util.List;

public interface AccountResourceDao {
    List<AccountResourceEntity> getListOfAccountResources(Integer accountId);
    void cleanAccountResourses(int accountId);
    List<AccountResourceQuantityEntity> getAccountResourcesQuantity(Integer accountId);
}
