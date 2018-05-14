package game.services;

import game.controllers.dto.AccountAchievementDto;

import java.util.List;

public interface AccountAchievementService {
    List<AccountAchievementDto>getListOfAccountAchievements(int accountId);
    void clearAccountAchievementsList(int accountId);
    void addAchievementToAccount(int accountId, int achievementId);
}
