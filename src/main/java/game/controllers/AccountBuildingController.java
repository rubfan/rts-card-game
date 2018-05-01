package game.controllers;

import game.controllers.dto.AccountBuildingDto;

import java.util.List;

public interface AccountBuildingController {

    List<AccountBuildingDto> getAccountBuildingsList(Integer accountId);
}
