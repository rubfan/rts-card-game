package game.controllers;

import game.controllers.dto.AccountBuildingDto;

import java.util.List;

public interface AccountBuildingController {

    List<AccountBuildingDto> getAccountBuildingsList(Integer accountId);
    void clearAccountBuildingsList(Integer accountId);
    void addBuildingToAccount(Integer accountId, Integer buildingId);
}
