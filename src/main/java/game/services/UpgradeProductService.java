package game.services;

import game.controllers.dto.UpgradeProductDto;

import java.util.List;

public interface UpgradeProductService {
    List<UpgradeProductDto> getListOfUpgradeProducts();
}
