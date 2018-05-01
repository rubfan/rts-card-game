package game.services.impl;

import game.controllers.dto.UpgradeDto;
import game.repositories.dao.UpgradeDao;
import game.services.UpgradeService;

import javax.inject.Inject;
import java.util.LinkedList;
import java.util.List;

public class UpgradeServiceImpl implements UpgradeService {

    @Inject
    UpgradeDao upgradeDao;

    @Override
    public List<UpgradeDto> getListOfUpgrades() {
        final List<UpgradeDto> upgrades = new LinkedList<>();
        upgradeDao.getListOfUpgrades().forEach(upgradeEntity ->  {
            upgrades.add(new UpgradeDto(){{
                setId(upgradeEntity.getId());
                setName(upgradeEntity.getName());
                setDescription(upgradeEntity.getDescription());
            }});
        });
        return upgrades;
    }
}
