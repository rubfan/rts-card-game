package game.services;

import game.controllers.dto.UpgradeDto;

import java.util.List;

public interface UpgradeService {
    List<UpgradeDto> getListOfUpgrades();
}
