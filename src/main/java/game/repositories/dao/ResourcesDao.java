package game.repositories.dao;

import game.repositories.entities.ResourcesEntity;

import java.util.List;

public interface ResourcesDao {
    List<ResourcesEntity> getListOfResources();
}
