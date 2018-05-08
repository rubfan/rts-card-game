package game.controllers;

import game.controllers.dto.AchievementDto;

import java.util.List;

public interface AchievementController {
    List<AchievementDto> getListOfAchievements();
}
