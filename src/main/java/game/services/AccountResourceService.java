package game.services;

import game.controllers.dto.AccountResourceDto;

import java.util.List;

public interface AccountResourceService {
    List<AccountResourceDto> getListOfAccountResources(Integer accountId);
}
