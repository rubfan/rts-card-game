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
import java.util.LinkedList;
import java.util.List;

public class BuildingProductDaoImpl implements BuildingProductDao {
    @Override
    public List<BuildingProductEntity> getListOfBuildingResources() {
        final List<BuildingProductEntity> buildingProducts = new LinkedList<BuildingProductEntity>();

        return new QueryHelper<List<BuildingProductEntity>>() {
            protected void executeQuery(Statement statement, Connection connection) throws SQLException {
                statement.executeUpdate("use card_battle_rts");
                ResultSet rs = statement.executeQuery("select building_id, b.name, b.description " +
                                                            "from Building_Product bp " +
                                                            "inner join Building b " +
                                                            "on bp.building_id = b.id");
                while(rs.next()) {
                    BuildingProductEntity buildingProduct = new BuildingProductEntity(
                            new BuildingEntity(
                                    rs.getInt("building_id"),
                                    rs.getString("name"),
                                    rs.getString("description")
                            ),
                            prepareProductList(rs.getInt("building_id"))

                    );
                    buildingProducts.add(buildingProduct);
                }
                setResult(buildingProducts);
            }
        }.run();
    }

    private List<ProductEntity> prepareProductList(Integer buildingId) {

        List<ProductEntity> productEntityList = new LinkedList<>();

        return new QueryHelper<List<ProductEntity>>() {
            protected void executeQuery(Statement statement, Connection connection) throws SQLException {
                ResultSet rs = statement.executeQuery("select r.id, r.name, r.description,bp.number_per_sec " +
                                                            "from Building_Product bp " +
                                                            "inner join Resource r " +
                                                            "on bp.resource_id = r.id " +
                                                            "where bp.building_id = "+ buildingId +";");
                while(rs.next()) {
                    ProductEntity productEntity = new ProductEntity(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("description"),
                            rs.getInt("number_per_sec")
                    );
                    productEntityList.add(productEntity);
                }
                setResult(productEntityList);
            }
        }.run();
    }
}
