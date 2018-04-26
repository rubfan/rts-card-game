package game.controllers;

import game.controllers.dto.BuildingDto;

import java.util.List;

public interface BuildingController {
    List<BuildingDto> getBuildingList();
}
