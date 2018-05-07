package game.repositories.dao.impl;

import game.repositories.dao.AccountBuildingDao;
import game.repositories.dao.helpers.QueryHelper;
import game.repositories.entities.AccountBuildingEntity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class AccountBuildingDaoImpl implements AccountBuildingDao {
    @Override
    public void clearAccountBuildingsList(int accountId) {
        new QueryHelper() {
            protected void executeQuery(Statement statement, Connection connection) throws SQLException {
                statement.executeUpdate("use card_battle_rts");
                statement.executeUpdate("DELETE FROM Account_Building WHERE account_id = " + accountId);
            }
        }.run();
    }

    @Override
    public void addBuildingToAccount(int accountId, int buildingId) {
        new QueryHelper() {
            protected void executeQuery(Statement statement, Connection connection) throws SQLException {
                statement.executeUpdate("use card_battle_rts");
                if (statement.executeQuery("SELECT * FROM Account_Building WHERE account_id = " +
                        accountId + " AND building_id = " + buildingId).next()) {
                    statement.executeUpdate("UPDATE Account_Building SET number = number + 1 " +
                            "WHERE account_id = " + accountId + " AND building_id = " + buildingId);
                }
                else {
                    statement.executeUpdate("INSERT INTO Account_Building " +
                            "(account_id, building_id, number)" +
                            "VALUES (" + accountId + "," + buildingId + "," + 1 + ")");
                }
            }
        }.run();
    }

    @Override
    public List<AccountBuildingEntity> getListOfAccountBuildings(int accountId) {

        final List<AccountBuildingEntity> accountBuildings = new LinkedList<AccountBuildingEntity>();
        new QueryHelper() {
            protected void executeQuery(Statement statement, Connection connection) throws SQLException {
                statement.executeUpdate("use card_battle_rts");
                ResultSet rs = statement.executeQuery("select * from Account_Building WHERE account_id = " + accountId);
                while(rs.next()) {
                    AccountBuildingEntity accountBuilding = new AccountBuildingEntity(
                            rs.getInt("account_id"),
                            rs.getInt("building_id"),
                            rs.getFloat("number")
                    );
                    accountBuildings.add(accountBuilding);
                }
            }
        }.run();
        return accountBuildings;
    }
}
