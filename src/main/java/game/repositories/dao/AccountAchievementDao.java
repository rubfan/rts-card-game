package game.repositories.dao;

import game.repositories.entities.AccountAchievementEntity;

import java.util.List;

public interface AccountAchievementDao {
    List<AccountAchievementEntity> getListOfAccountAchievements(int accountId);
    void clearAccountAchievementList(int accountId);
    void addAchievementToAccount(int accountId, int achievementId);
}
