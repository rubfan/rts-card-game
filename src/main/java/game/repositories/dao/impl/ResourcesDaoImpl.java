package game.repositories.dao.impl;

import game.repositories.dao.ResourcesDao;
import game.repositories.dao.helpers.QueryHelper;
import game.repositories.entities.ResourcesEntity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class ResourcesDaoImpl implements ResourcesDao {

    public List<ResourcesEntity> getListOfResources() {
        final List<ResourcesEntity> resources = new LinkedList<ResourcesEntity>();

        new QueryHelper() {
            protected void executeQuery(Statement statement, Connection connection) throws SQLException {
                statement.executeUpdate("use card_battle_rts");
                ResultSet rs = statement.executeQuery("select * from resource");
                while(rs.next()) {
                    ResourcesEntity resource = new ResourcesEntity(
                            rs.getInt("id"),
//                            rs.getInt("number"),
                            rs.getString("name"),
                            rs.getString("description")
                    );
                    resources.add(resource);
                }
            }
        }.run();

        return resources;
    }

}
