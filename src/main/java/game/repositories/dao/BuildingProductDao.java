package game.repositories.dao;

import game.repositories.entities.BuildingProductEntity;

import java.util.Collection;

public interface BuildingProductDao {

    Collection<BuildingProductEntity> getListOfBuildingResources();
}
