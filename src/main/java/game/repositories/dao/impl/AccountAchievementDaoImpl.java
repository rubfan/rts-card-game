package game.repositories.dao.impl;

import game.repositories.dao.AccountAchievementDao;
import game.repositories.dao.helpers.QueryHelper;
import game.repositories.entities.AccountAchievementEntity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class AccountAchievementDaoImpl implements AccountAchievementDao{
    @Override
    public void clearAccountAchievementList(int accountId) {
        new QueryHelper() {
            protected void executeQuery(Statement statement, Connection connection) throws SQLException {
                statement.executeUpdate("DELETE FROM Account_Achievement WHERE account_id = " + accountId);
            }
        }.run();
    }

    @Override
    public void addAchievementToAccount(int accountId, int achievementId) {
        new QueryHelper() {
            protected void executeQuery(Statement statement, Connection connection) throws SQLException {
                if (statement.executeQuery("SELECT * FROM Account_Achievement WHERE account_id = " +
                        accountId + " AND achievement_id = " + achievementId).next()) {
                    statement.executeUpdate("UPDATE Account_Achievement SET number = number + 1 " +
                            "WHERE account_id = " + accountId + " AND Achievement_id = " + achievementId);
                } else {
                    statement.executeUpdate("INSERT INTO Account_Achievement " +
                            "(account_id, achievement_id, number)" +
                            "VALUES (" + accountId + "," + achievementId + "," + 1 + ")");
                }
                connection.commit();
            }
        }.run();
    }

    @Override
    public List<AccountAchievementEntity> getListOfAccountAchievements(int accountId) {
        return new QueryHelper<List<AccountAchievementEntity>>() {
            protected void executeQuery(Statement statement, Connection connection) throws SQLException {
                List<AccountAchievementEntity> accountAchievements = new LinkedList<>();
                ResultSet rs = statement.executeQuery(
                        "select * from Account_Achievement WHERE account_id = " + accountId);
                while(rs.next()) {
                    AccountAchievementEntity accountAchievement = new AccountAchievementEntity(
                            rs.getInt("account_id"),
                            rs.getInt("achievement_id"),
                            rs.getFloat("number")
                    );
                    accountAchievements.add(accountAchievement);
                }
                returnResult(accountAchievements);
            }
        }.run();
    }
}
