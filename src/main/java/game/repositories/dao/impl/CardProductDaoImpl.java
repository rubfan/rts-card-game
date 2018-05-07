package game.repositories.dao.impl;

import game.repositories.dao.CardProductDao;
import game.repositories.dao.helpers.QueryHelper;
import game.repositories.entities.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class CardProductDaoImpl implements CardProductDao {
    @Override
    public Collection<CardProductEntity> getListOfCardProducts() {
        final Map<Integer, CardProductEntity> cardProducts = new HashMap<>();

        return new QueryHelper<Collection<CardProductEntity>>() {
            protected void executeQuery(Statement statement, Connection connection) throws SQLException {
                statement.executeUpdate("use card_battle_rts");
                ResultSet rs = statement.executeQuery(
                        "SELECT cp.id, cp.card_id, cp.p1_building_id, cp.p2_building_id, cp.p1_building_number, cp.p2_building_number, cp.p1_resource_id, cp.p2_resource_id, cp.p1_resource_number, cp.p2_resource_number, cp.p1_upgrade_id, cp.p1_upgrade_number, cp.p2_upgrade_number," +
                                "c.name 'card_name', c.description 'card_description', " +
                                "u1.account_id 'account_id', u1.upgrade_id 'upgrade_id', u1.number 'number', " +
                                "u2.account_id 'account_id', u2.upgrade_id 'upgrade_id', u2.number 'number', " +
                                "b1.account_id 'account_id', b1.building_id 'building_id', b1.number 'number', " +
                                "b2.account_id 'account_id', b2.building_id 'building_id', b2.number 'number', " +
                                "r1.account_id 'account_id', r1.resource_id 'resource_id', r1.number 'number', " +
                                "r2.account_id 'account_id', r2.resource_id 'resource_id', r2.number 'number', " +
                                "cp.necessary_building_id, cp.necessary_upgrade_id, cp.necessary_building_number, cp.necessary_upgrade_number " +
                                "FROM Card_Product cp " +
                                "LEFT JOIN Card c ON c.id = cp.card_id " +
                                "LEFT JOIN Account_Upgrade u1 ON u1.account_id = cp.p1_upgrade_id " +
                                "LEFT JOIN Account_Upgrade u2 ON u2.account_id = cp.p2_upgrade_id " +
                                "LEFT JOIN Account_Building b1 ON b1.account_id = cp.p1_building_id " +
                                "LEFT JOIN Account_Building b2 ON b2.account_id = cp.p2_building_id " +
                                "LEFT JOIN Account_Resource r1 ON r1.account_id = cp.p1_resource_id " +
                                "LEFT JOIN Account_Resource r2 ON r2.account_id = cp.p2_resource_id "

                );
                while (rs.next()) {
                    CardProductEntity cardProduct = new CardProductEntity();
                    cardProduct.setCardEntity(getCardEntity(rs));
                    if(!cardProducts.containsKey(cardProduct.getCardEntity().getId())){
                        cardProduct.setId(rs.getInt("id"));
                        cardProduct.setP1buildingList(new LinkedList<>());
                        cardProduct.setP2buildingList(new LinkedList<>());
                        cardProduct.setP1accountResourceList(new LinkedList<>());
                        cardProduct.setP2accountResourceList(new LinkedList<>());
                        cardProduct.setP1accountUpgradeList(new LinkedList<>());
                        cardProduct.setP2accountUpgradeList(new LinkedList<>());
                        cardProduct.setNecessaryBuildingList(new LinkedList<>());
                        cardProduct.setNecessaryAccountUpgradeList(new LinkedList<>());
                        cardProducts.put(cardProduct.getCardEntity().getId(), cardProduct);
                    } else {
                        cardProduct = cardProducts.get(cardProduct.getCardEntity().getId());
                    }
                        cardProduct.getP1buildingList().add(getAccountBuildingEntity(rs));
                        cardProduct.getP2buildingList().add(getAccountBuildingEntity(rs));
                        cardProduct.getP1accountResourceList().add(getAccountResourceEntity(rs));
                        cardProduct.getP2accountResourceList().add(getAccountResourceEntity(rs));
                        cardProduct.getP1accountUpgradeList().add(getAccountUpgradeEntity(rs));
                        cardProduct.getP2accountUpgradeList().add(getAccountUpgradeEntity(rs));
                        cardProduct.getNecessaryBuildingList().add(getAccountBuildingEntity(rs));
                        cardProduct.getNecessaryAccountUpgradeList().add(getAccountUpgradeEntity(rs));
                }
                if(cardProducts.size() > 0) {
                    setResult(cardProducts.values());
                }
            }
        }.run();
    }
    private CardEntity getCardEntity(ResultSet rs) throws SQLException {
        return new CardEntity() {{
            setId(rs.getInt("card_id"));
            setName(rs.getString("card_name"));
            setDescription(rs.getString("card_description"));
        }};
    }

    private AccountBuildingEntity getAccountBuildingEntity(ResultSet rs) throws SQLException {
        return new AccountBuildingEntity() {{
            setAccountId(rs.getInt("account_id"));
            setBuildingId(rs.getInt("building_id"));
            setNumber(rs.getFloat("number"));
        }};
    }

    private AccountResourceEntity getAccountResourceEntity(ResultSet rs) throws SQLException {
        return new AccountResourceEntity() {{
            setAccountId(rs.getInt("account_id"));
            setResourceId(rs.getInt("resource_id"));
            setQuantity(rs.getInt("number"));
        }};
    }

    private AccountUpgradeEntity getAccountUpgradeEntity(ResultSet rs) throws SQLException {
        return new AccountUpgradeEntity() {{
            setAccountId(rs.getInt("account_id"));
            setUpgradeId(rs.getInt("upgrade_id"));
            setQuantity(rs.getInt("number"));
        }};
    }
}

