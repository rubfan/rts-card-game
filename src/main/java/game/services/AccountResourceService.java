package game.services;

import game.controllers.dto.AccountResourceDto;
import game.controllers.dto.AccountResourceQuantityDto;

import java.util.List;

public interface AccountResourceService {
    List<AccountResourceDto> getListOfAccountResources(Integer accountId);
    List<AccountResourceQuantityDto> getAccountResourcesQuantity(Integer accountId);
}
