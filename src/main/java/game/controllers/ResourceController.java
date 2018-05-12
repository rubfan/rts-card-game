package game.controllers;

import game.controllers.dto.ResourceDto;

import java.util.List;

public interface ResourceController {
    List<ResourceDto> getListOfResources();
}
