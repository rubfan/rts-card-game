package game.services;

import game.controllers.dto.ResourceDto;

import java.util.List;

public interface ResourceService {
    List<ResourceDto> getListOfResources();
}
