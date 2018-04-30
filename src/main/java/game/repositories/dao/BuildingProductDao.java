package game.repositories.dao;

import game.repositories.entities.BuildingProductEntity;

import java.util.List;

public interface BuildingProductDao {

    List<BuildingProductEntity> getListOfBuildingResources();
}
