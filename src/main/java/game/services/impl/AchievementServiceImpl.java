package game.services.impl;

import game.controllers.dto.AchievementDto;
import game.repositories.dao.AchievementDao;
import game.services.AchievementService;

import javax.inject.Inject;
import java.util.LinkedList;
import java.util.List;

public class AchievementServiceImpl implements AchievementService{

    @Inject
    public AchievementDao achievementDao;

    public List<AchievementDto> getListOfAchievements(){
        final List<AchievementDto> achievement = new LinkedList<>();
        achievementDao.getListOfAchievements().forEach(achievementEntity -> {
            achievement.add(new AchievementDto(){{
                setId(achievementEntity.getId());
                setName(achievementEntity.getName());
                setDescription(achievementEntity.getDescription());
            }});
        });
        return achievement;
    }


}
