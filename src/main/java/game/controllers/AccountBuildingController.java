package game.controllers;

import game.controllers.dto.AccountBuildingDto;

import javax.ws.rs.core.Response;
import java.util.List;

public interface AccountBuildingController {

    List<AccountBuildingDto> getAccountBuildingsList(Integer accountId);
    Response clearAccountBuildingsList(Integer accountId);
    Response addBuildingToAccount(Integer accountId, Integer buildingId);
}
