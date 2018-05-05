package game.controllers;

import game.controllers.dto.AccountResourceDto;

import java.util.List;

public interface AccountResourceController {
    List<AccountResourceDto> getAccountResourcesList(Integer accountId);
}
