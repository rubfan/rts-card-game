package game.repositories.dao.impl;

import game.repositories.dao.BuildingDao;
import game.repositories.dao.helpers.QueryHelper;
import game.repositories.entities.BuildingEntity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class BuildingDaoImpl implements BuildingDao {

    @Override
    public List<BuildingEntity> getListOfBuildings() {
        return new QueryHelper<List<BuildingEntity>>() {
            protected void executeQuery(Statement statement, Connection connection) throws SQLException {
                List<BuildingEntity> buildings = new LinkedList<>();
                ResultSet rs = statement.executeQuery("select * from Building");
                while(rs.next()) {
                    BuildingEntity building = new BuildingEntity(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("description")
                    );
                    buildings.add(building);
                }
                returnResult(buildings);
            }
        }.run();
    }
}
