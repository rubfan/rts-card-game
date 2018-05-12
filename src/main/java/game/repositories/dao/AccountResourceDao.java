package game.repositories.dao;

import game.repositories.entities.AccountResourceEntity;

import java.util.List;

public interface AccountResourceDao {
    List<AccountResourceEntity> getListOfAccountResources(Integer accountId);
}
