package game.repositories.dao.impl;

import game.repositories.dao.ProductDao;
import game.repositories.dao.helpers.QueryHelper;
import game.repositories.entities.ProductEntity;
import game.repositories.entities.ResourceEntity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {



    @Override
    public List<ProductEntity> getListOfProductByBuldingId(Integer buildingId) {
        final List<ProductEntity> products = new LinkedList<>();

        new QueryHelper() {
            @Override
            protected void executeQuery(Statement statement, Connection connection) throws SQLException {
                ResultSet rs = statement.executeQuery("select building_id, " +
                        "resource_id, " +
                        "Resource.name, " +
                        "Resource.description," +
                        "number_per_sec " +
                        "from Building_Product " +
                        "left join Resource " +
                        "on resource_id = Resource.id " +
                        "where building_id = " + buildingId + ";");
                while (rs.next()) {
                    ProductEntity productEntity = new ProductEntity(
                        rs.getInt("building_id"),
                        new ResourceEntity(
                                rs.getInt("resource_id"),
                                rs.getString("name"),
                                rs.getString("description")
                        ),
                        rs.getInt("number_per_sec")
                    );
                    products.add(productEntity);
                }
            }
        }.run();

        return products;
    }
}
