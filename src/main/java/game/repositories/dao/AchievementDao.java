package game.repositories.dao;

import game.repositories.entities.AchievementEntity;

import java.util.List;

public interface AchievementDao {
    List<AchievementEntity> getListOfAchievements();
}
