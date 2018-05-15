package game.controllers;

import game.controllers.dto.AccountAchievementDto;

import javax.ws.rs.core.Response;
import java.util.List;

public interface AccountAchievementController {
    List<AccountAchievementDto> getAccountAchievementsList(Integer accountId);
    Response clearAccountAchievementsList(Integer accountId);
    Response addAchievementToAccount(Integer accountId, Integer achievementId);
}
