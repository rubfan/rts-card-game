package game.controllers;

import game.controllers.dto.UpgradeDto;

import java.util.List;

public interface UpgradeController {
    List<UpgradeDto> getUpgradeList();
}
