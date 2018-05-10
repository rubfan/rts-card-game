package game.services;

import game.controllers.dto.AccountUpgradeDto;

import java.util.List;

public interface AccountUpgradeService {
    List<AccountUpgradeDto> getListOfAccountUpgrades(Integer accountId);
}
