package game.repositories.dao.impl;

import game.repositories.dao.ResourceDao;
import game.repositories.dao.helpers.QueryHelper;
import game.repositories.entities.ResourceEntity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class ResourceDaoImpl implements ResourceDao {

    public List<ResourceEntity> getListOfResources() {
        return new QueryHelper<List<ResourceEntity>>() {
            protected void executeQuery(Statement statement, Connection connection) throws SQLException {
                List<ResourceEntity> resources = new LinkedList<>();
                ResultSet rs = statement.executeQuery("select * from Resource");
                while(rs.next()) {
                    ResourceEntity resource = new ResourceEntity(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("description")
                    );
                    resources.add(resource);
                }
                returnResult(resources);
            }
        }.run();
    }

}
