package game.services;

import game.controllers.dto.BuildingProductDto;

import java.util.List;

public interface BuildingProductService {

    List<BuildingProductDto> getListOfBuildingResources();
}
