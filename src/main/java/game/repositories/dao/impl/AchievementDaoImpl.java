package game.repositories.dao.impl;

import game.repositories.dao.AchievementDao;
import game.repositories.dao.helpers.QueryHelper;
import game.repositories.entities.AchievementEntity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class AchievementDaoImpl implements AchievementDao {
    public List<AchievementEntity> getListOfAchievements() {
        return new QueryHelper<List<AchievementEntity>>() {
            protected void executeQuery(Statement statement, Connection connection) throws SQLException {
                List<AchievementEntity> achievements = new LinkedList<>();
                ResultSet rs = statement.executeQuery("select * from Achievement");
                while(rs.next()) {
                    AchievementEntity achievement = new AchievementEntity(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("description")
                    );
                    achievements.add(achievement);
                }
                returnResult(achievements);
            }
        }.run();
    }
}
