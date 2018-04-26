package game.services;

import game.controllers.dto.BuildingDto;

import java.util.List;

public interface BuildingService {
    List<BuildingDto> getListOfBuildings();
}
