package game.services.impl;

import game.controllers.dto.AccountAchievementDto;
import game.repositories.dao.AccountAchievementDao;
import game.services.AccountAchievementService;

import javax.inject.Inject;
import java.util.LinkedList;
import java.util.List;

public class AccountAchievementServiceImpl implements AccountAchievementService {
    @Inject
    public AccountAchievementDao accountAchievementDao;

    @Override
    public List<AccountAchievementDto> getListOfAccountAchievements(int accountId) {
        final List<AccountAchievementDto> accountAchievements = new LinkedList<>();
        accountAchievementDao.getListOfAccountAchievements(accountId).forEach(accountAchievementEntity -> {
            accountAchievements.add(new AccountAchievementDto(){{
                setAccountId(accountAchievementEntity.getAccountId());
                setAchievementId(accountAchievementEntity.getAchievementId());
                setNumber(accountAchievementEntity.getNumber());
            }});
        });
        return accountAchievements;
    }

    @Override
    public void clearAccountAchievementsList(int accountId) {
        accountAchievementDao.clearAccountAchievementList(accountId);
    }

    @Override
    public void addAchievementToAccount(int accountId, int achievementId) {
        accountAchievementDao.addAchievementToAccount(accountId,achievementId);
    }
}
