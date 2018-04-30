package game.repositories.dao;

import game.repositories.entities.ResourceEntity;

import java.util.List;

public interface ResourceDao {
    List<ResourceEntity> getListOfResources();
}
