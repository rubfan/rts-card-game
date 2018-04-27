package game.controllers;

import game.controllers.dto.ResourсesDto;

import java.util.List;

public interface ResourcesController {
    List<ResourсesDto> getListOfResources();
}
