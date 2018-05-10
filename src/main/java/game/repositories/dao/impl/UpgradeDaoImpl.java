package game.repositories.dao.impl;

import game.repositories.dao.UpgradeDao;
import game.repositories.dao.helpers.QueryHelper;

import game.repositories.entities.UpgradeEntity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class UpgradeDaoImpl implements UpgradeDao {


    public List<UpgradeEntity> getListOfUpgrades() {
        return new QueryHelper<List<UpgradeEntity>>(){
            protected void executeQuery(Statement statement, Connection connection) throws SQLException {
                List<UpgradeEntity> upgrades = new LinkedList<>();
                ResultSet rs = statement.executeQuery("select * from Upgrade");
                while(rs.next()) {
                    UpgradeEntity upgrade = new UpgradeEntity(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("description")
                    );
                    upgrades.add(upgrade);
                }
                returnResult(upgrades);
            }
        }.run();
    }

}
