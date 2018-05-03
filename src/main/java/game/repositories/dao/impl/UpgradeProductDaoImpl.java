package game.repositories.dao.impl;

import game.repositories.dao.UpgradeProductDao;
import game.repositories.dao.helpers.QueryHelper;
import game.repositories.entities.UpgradeEntity;
import game.repositories.entities.UpgradeProductEntity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class UpgradeProductDaoImpl implements UpgradeProductDao {

    @Override
    public List<UpgradeProductEntity> getListOfUpgradeResources() {
        final List<UpgradeProductEntity> upgradeProducts = new LinkedList<>();

        new QueryHelper() {
            protected void executeQuery(Statement statement, Connection connection) throws SQLException {
                statement.executeUpdate("use card_battle_rts");
                ResultSet rs = statement.executeQuery("select up.id from Upgrade_Product "+
                                                          "left join Upgrade u on up.id = u.id "
                );
                while (rs.next()) {
                    UpgradeProductEntity upgradeProduct = new UpgradeProductEntity();
                        upgradeProduct.setId(rs.getInt("id"));
                        upgradeProduct.setUpgradeEntity(prepareUpgradeEntity(rs.getInt("id")));
//                        upgradeProduct.setResourceEntityList(setList<ResourceQuantityEntity>);
//                        upgradeProduct.setBuildingEntities(setList<BuildingEntity>);
                }

            }
        }.run();
        return upgradeProducts;
    }

    private UpgradeEntity prepareUpgradeEntity(Integer id){
            final UpgradeEntity[] upgrade = new UpgradeEntity[1];
            new QueryHelper(){
                protected void executeQuery(Statement statement, Connection connection) throws SQLException {
                    statement.executeUpdate("use card_battle_rts");
                    ResultSet rs = statement.executeQuery("select * from Upgrade where id = " + id);
                    upgrade[0] = new UpgradeEntity(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("description")
                    );
                }
            }.run();
            return upgrade[0];
        }

}
