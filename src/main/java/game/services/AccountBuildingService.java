package game.services;

import game.controllers.dto.AccountBuildingDto;

import java.util.List;

public interface AccountBuildingService {
    List<AccountBuildingDto> getListOfAccountBuildings(int accountId);
}
