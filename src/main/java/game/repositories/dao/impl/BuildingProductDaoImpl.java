package game.repositories.dao.impl;

import game.repositories.dao.BuildingProductDao;
import game.repositories.dao.helpers.QueryHelper;
import game.repositories.entities.BuildingEntity;
import game.repositories.entities.BuildingProductEntity;
import game.repositories.entities.ProductEntity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class BuildingProductDaoImpl implements BuildingProductDao {

    @Override
    public Collection<BuildingProductEntity> getListOfBuildingResources() {
        return new QueryHelper<Collection<BuildingProductEntity>>() {
            protected void executeQuery(Statement statement, Connection connection) throws SQLException {

                Map<Integer,BuildingProductEntity> buildingProducts = new HashMap<>();

                ResultSet rs = statement.executeQuery("SELECT bp.id," +
                        "building_id," +
                        "b.name `building_name`," +
                        "b.description `building_description`," +
                        "resource_id," +
                        "r.name `resource_name`," +
                        "r.description `resource_description`," +
                        "bp.number_per_sec " +
                        "FROM Building_Product bp " +
                        "LEFT JOIN Building b " +
                        "ON building_id = b.id " +
                        "LEFT JOIN Resource r " +
                        "ON resource_id = r.id");

                while(rs.next()) {
                    BuildingProductEntity buildingProduct = new BuildingProductEntity();
                    buildingProduct.setBuildingEntity(prepareBuilding(rs));
                    if(!buildingProducts.containsKey(buildingProduct.getBuildingEntity().getId())) {
                        buildingProduct.setId(rs.getInt("id"));
                        buildingProduct.setProductEntityList(new LinkedList<>());
                        buildingProducts.put(buildingProduct.getBuildingEntity().getId(),buildingProduct);
                    } else {
                        buildingProduct = buildingProducts.get(buildingProduct.getBuildingEntity().getId());
                    }
                    buildingProduct.getProductEntityList().add(prepareProduct(rs));
                }
                returnResult(buildingProducts.values());
            }
        }.run();
    }


    private BuildingEntity prepareBuilding(ResultSet rs) throws SQLException {
        return new BuildingEntity(){{
            setId(rs.getInt("building_id"));
            setName(rs.getString("building_name"));
            setDescription(rs.getString("building_description"));
        }};
    }

    private ProductEntity prepareProduct(ResultSet rs) throws SQLException {
        return new ProductEntity(){{
            setId(rs.getInt("resource_id"));
            setName(rs.getString("resource_name"));
            setDescription(rs.getString("resource_description"));
            setNumPerSec(rs.getInt("number_per_sec"));
        }};
    }
}
