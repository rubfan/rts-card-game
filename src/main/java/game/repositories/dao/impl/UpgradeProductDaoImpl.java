package game.repositories.dao.impl;

import game.repositories.dao.UpgradeProductDao;
import game.repositories.dao.helpers.QueryHelper;
import game.repositories.entities.BuildingEntity;
import game.repositories.entities.ResourceQuantityEntity;
import game.repositories.entities.UpgradeEntity;
import game.repositories.entities.UpgradeProductEntity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class UpgradeProductDaoImpl implements UpgradeProductDao {

    @Override
    public Collection<UpgradeProductEntity> getListOfUpgradeProducts() {
        return new QueryHelper<Collection<UpgradeProductEntity>>() {
            protected void executeQuery(Statement statement, Connection connection) throws SQLException {
                Map<Integer, UpgradeProductEntity> upgradeProducts = new HashMap<>();
                ResultSet rs = statement.executeQuery(prepareUpgradeProductsQuery());
                while (rs.next()) {
                    UpgradeProductEntity upgradeProduct = new UpgradeProductEntity();
                    upgradeProduct.setUpgradeEntity(getUpgradeEntity(rs));
                    if(!upgradeProducts.containsKey(upgradeProduct.getUpgradeEntity().getId())){
                        upgradeProduct.setId(rs.getInt("id"));
                        upgradeProduct.setBuildingEntityList(new LinkedList<>());
                        upgradeProduct.setResourceEntityList(new LinkedList<>());
                        upgradeProducts.put(upgradeProduct.getUpgradeEntity().getId(), upgradeProduct);
                    } else {
                        upgradeProduct = upgradeProducts.get(upgradeProduct.getUpgradeEntity().getId());
                    }
                    upgradeProduct.getBuildingEntityList().add(getBuildingEntity(rs));
                    upgradeProduct.getResourceEntityList().add(getResourceQuantityEntity(rs));

                }
                if(upgradeProducts.size() > 0) {
                    returnResult(upgradeProducts.values());
                }
            }
        }.run();
    }

    private String prepareUpgradeProductsQuery(){
        StringBuilder q = new StringBuilder();
        q.append("SELECT up.id, up.upgrade_id, up.building_id, up.resource_id, ");
            q.append("u.name 'upgrade_name', u.description 'upgrade_description', ");
            q.append("b.name 'building_name', b.description 'building_description', ");
            q.append("r.name 'resource_name', r.description 'resource_description', ");
            q.append("up.percent ");
        q.append("FROM Upgrade_Product up ");
        q.append("LEFT JOIN Upgrade u ON u.id = up.upgrade_id ");
        q.append("LEFT JOIN Building b ON b.id = up.building_id ");
        q.append("LEFT JOIN Resource r ON r.id = up.resource_id ");
        return q.toString();
    }

    private UpgradeEntity getUpgradeEntity(ResultSet rs) throws SQLException {
        return new UpgradeEntity() {{
            setId(rs.getInt("upgrade_id"));
            setName(rs.getString("upgrade_name"));
            setDescription(rs.getString("upgrade_description"));
        }};
    }

    private BuildingEntity getBuildingEntity(ResultSet rs) throws SQLException {
        return new BuildingEntity() {{
            setId(rs.getInt("building_id"));
            setName(rs.getString("building_name"));
            setDescription(rs.getString("building_description"));
        }};
    }

    private ResourceQuantityEntity getResourceQuantityEntity(ResultSet rs) throws SQLException {
        return new ResourceQuantityEntity() {{
            setId(rs.getInt("resource_id"));
            setName(rs.getString("resource_name"));
            setDescription(rs.getString("resource_description"));
            setQuantity(rs.getFloat("percent"));
        }};
    }
}
