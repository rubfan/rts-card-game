package game.controllers.impl;

import game.controllers.AchievementController;
import game.controllers.dto.AchievementDto;
import game.services.AchievementService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


    @Path("/achievement")
    public class AchievementControllerImpl implements AchievementController {


        @Inject
        public AchievementService achievementService;

        @GET
        @Path("/list")
        public List<AchievementDto> getListOfAchievements(){
            List<AchievementDto> AchievementList = achievementService.getListOfAchievements();
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, AchievementList.toString());
            return AchievementList;
        }
}
