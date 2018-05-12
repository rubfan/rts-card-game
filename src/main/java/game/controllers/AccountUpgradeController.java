package game.controllers;

import game.controllers.dto.AccountUpgradeDto;

import java.util.List;

public interface AccountUpgradeController {

    List<AccountUpgradeDto> getAccountUpgradeList(Integer accountId);
}
