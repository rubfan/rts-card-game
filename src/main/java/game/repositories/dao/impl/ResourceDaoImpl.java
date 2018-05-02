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

<<<<<<< HEAD:src/main/java/game/repositories/dao/impl/ResourcesDaoImpl.java
<<<<<<< HEAD
    public List<ResourcesEntity> getListOfCards() {
=======
    public List<ResourcesEntity> getListOfResources() {
>>>>>>> f51361c04eafcd0a0918362d237cfad9254d7047
        final List<ResourcesEntity> resources = new LinkedList<ResourcesEntity>();
=======
    public List<ResourceEntity> getListOfResources() {
        final List<ResourceEntity> resources = new LinkedList<ResourceEntity>();
>>>>>>> 07b3999f3ebe14f462141f2d600db736f993e516:src/main/java/game/repositories/dao/impl/ResourceDaoImpl.java

        new QueryHelper() {
            protected void executeQuery(Statement statement, Connection connection) throws SQLException {
                statement.executeUpdate("use card_battle_rts");
<<<<<<< HEAD:src/main/java/game/repositories/dao/impl/ResourcesDaoImpl.java
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
=======
                ResultSet rs = statement.executeQuery("select * from Resource");
>>>>>>> 07b3999f3ebe14f462141f2d600db736f993e516:src/main/java/game/repositories/dao/impl/ResourceDaoImpl.java
                while(rs.next()) {
                    ResourceEntity resource = new ResourceEntity(
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
