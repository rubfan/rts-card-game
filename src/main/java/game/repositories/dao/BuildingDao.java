package game.repositories.dao;

import game.repositories.entities.BuildingEntity;

import java.util.List;

public interface BuildingDao {
    List<BuildingEntity> getListOfBuildings();
}
