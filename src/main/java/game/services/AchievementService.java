package game.services;

import game.controllers.dto.AchievementDto;

import java.util.List;

public interface AchievementService {
    List<AchievementDto> getListOfAchievements();
}
