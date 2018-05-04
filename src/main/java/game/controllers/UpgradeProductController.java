package game.controllers;

import game.controllers.dto.UpgradeProductDto;

import java.util.List;

public interface UpgradeProductController {
    List<UpgradeProductDto> getListOfUpgradeProducts();
}
