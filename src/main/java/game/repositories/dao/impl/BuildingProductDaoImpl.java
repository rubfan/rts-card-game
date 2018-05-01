package game.repositories.dao.impl;

import game.repositories.dao.BuildingProductDao;
import game.repositories.dao.helpers.QueryHelper;
import game.repositories.entities.BuildingProductEntity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class BuildingProductDaoImpl implements BuildingProductDao {
    @Override
    public List<BuildingProductEntity> getListOfBuildingResources() {
        final List<BuildingProductEntity> buildingProducts = new LinkedList<BuildingProductEntity>();

        new QueryHelper() {
            protected void executeQuery(Statement statement, Connection connection) throws SQLException {
                statement.executeUpdate("use card_battle_rts");
                ResultSet rs = statement.executeQuery("select * from Building_Product");
                while(rs.next()) {
                    BuildingProductEntity buildingProduct = new BuildingProductEntity(
                            rs.getInt("building_id"),
                            rs.getInt("resource_id"),
                            rs.getFloat("number_per_sec")
                    );
                    buildingProducts.add(buildingProduct);
                }
            }
        }.run();
        return buildingProducts;
    }
}
