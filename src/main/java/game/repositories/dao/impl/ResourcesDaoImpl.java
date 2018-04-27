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

<<<<<<< HEAD
    public List<ResourcesEntity> getListOfCards() {
=======
    public List<ResourcesEntity> getListOfResources() {
>>>>>>> f51361c04eafcd0a0918362d237cfad9254d7047
        final List<ResourcesEntity> resources = new LinkedList<ResourcesEntity>();

        new QueryHelper() {
            protected void executeQuery(Statement statement, Connection connection) throws SQLException {
                statement.executeUpdate("use card_battle_rts");
<<<<<<< HEAD
                ResultSet rs = statement.executeQuery("select * from resourses");
                while(rs.next()) {
                    ResourcesEntity resources = new ResourcesEntity(
                            rs.getInt("id"),
                            rs.getInt("number"),
                            rs.getString("name"),
                            rs.getString("description")
                    );
                    resources.add(resources);
=======
                ResultSet rs = statement.executeQuery("select * from resource");
                while(rs.next()) {
                    ResourcesEntity resource = new ResourcesEntity(
                            rs.getInt("id"),
//                            rs.getInt("number"),
                            rs.getString("name"),
                            rs.getString("description")
                    );
                    resources.add(resource);
>>>>>>> f51361c04eafcd0a0918362d237cfad9254d7047
                }
            }
        }.run();

        return resources;
    }

}
