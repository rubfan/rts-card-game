package game.controllers;

import game.controllers.dto.AccountResourceDto;
import game.controllers.dto.AccountResourceQuantityDto;

import java.util.List;

public interface AccountResourceController {
    List<AccountResourceDto> getAccountResourcesList(Integer accountId);
    List<AccountResourceQuantityDto> getAccountResourcesQuantity(Integer accountId);
}
