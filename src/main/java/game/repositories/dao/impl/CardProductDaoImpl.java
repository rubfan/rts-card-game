package game.repositories.dao.impl;

import game.repositories.dao.CardProductDao;
import game.repositories.dao.helpers.QueryHelper;
import game.repositories.entities.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class CardProductDaoImpl implements CardProductDao {
    @Override
    public Collection<CardProductEntity> getListOfCardProducts() {
        return new QueryHelper<Collection<CardProductEntity>>() {
            protected void executeQuery(Statement statement, Connection connection) throws SQLException {
                Map<Integer, CardProductEntity> cardProducts = new HashMap<>();
                ResultSet rs = statement.executeQuery(prepareListOfCardsProductQuery());
                while (rs.next()) {
                    CardProductEntity cardProduct = new CardProductEntity();
                    cardProduct.setCardEntity(getCardEntity(rs));
                    if (!cardProducts.containsKey(cardProduct.getCardEntity().getId())) {
                        cardProduct.setId(rs.getInt("id"));
                        cardProduct.setP1BuildingQuantityEntityList(new LinkedList<>());
                        cardProduct.setP2BuildingQuantityEntityList(new LinkedList<>());
                        cardProduct.setP1ResourceQuantityEntityList(new LinkedList<>());
                        cardProduct.setP2ResourceQuantityEntityList(new LinkedList<>());
                        cardProduct.setP1UpgradeQuantityEntityList(new LinkedList<>());
                        cardProduct.setP2UpgradeQuantityEntityList(new LinkedList<>());
                        cardProduct.setNecessaryBuildingQuantityEntityList(new LinkedList<>());
                        cardProduct.setNecessaryUpgradeQuantityEntityList(new LinkedList<>());
                        cardProducts.put(cardProduct.getCardEntity().getId(), cardProduct);
                    } else {
                        cardProduct = cardProducts.get(cardProduct.getCardEntity().getId());
                    }
                    cardProduct.getP1BuildingQuantityEntityList().add(getP1BuildingQuantityEntity(rs));
                    cardProduct.getP2BuildingQuantityEntityList().add(getP2BuildingQuantityEntity(rs));
                    cardProduct.getP1ResourceQuantityEntityList().add(getP1ResourceQuantityEntity(rs));
                    cardProduct.getP2ResourceQuantityEntityList().add(getP2ResourceQuantityEntity(rs));
                    cardProduct.getP1UpgradeQuantityEntityList().add(getP1UpgradeQuantityEntity(rs));
                    cardProduct.getP2UpgradeQuantityEntityList().add(getP2UpgradeQuantityEntity(rs));
                    cardProduct.getNecessaryBuildingQuantityEntityList().add(getNecessaryBuildingQuantityEntity(rs));
                    cardProduct.getNecessaryUpgradeQuantityEntityList().add(getNecessaryUpgradeQuantityEntity(rs));
                }
                if (cardProducts.size() > 0) {
                    returnResult(cardProducts.values());
                }
            }
        }.run();
    }

    @Override
    public List<Integer> getAllowAccountCards() {
        return new QueryHelper<List<Integer>>() {
            protected void executeQuery(Statement statement, Connection connection) throws SQLException {
                List<Integer> allowCards = new LinkedList<>();
                ResultSet rs = statement.executeQuery(prepareListOfAllowCardsforAccountQuery());
                while (rs.next()) {
                    allowCards.add(rs.getInt("card_id"));
                }
                if (allowCards.size() > 0) {
                    returnResult(allowCards);
                }
            }
        }.run();
    }

    @Override
    public void applyCard(Integer accountId, Integer cardId) {
        String pid, pnum;
        if (accountId == 1) {
            pid = "p1_building_id";
            pnum = "p1_building_number";
        } else {
            pid = "p2_building_id";
            pnum = "p2_building_number";
        }

        new QueryHelper() {
            protected void executeQuery(Statement statement, Connection connection) throws SQLException {
                if (statement.executeQuery("SELECT DISTINCT * FROM Account_Building WHERE account_id = " +
                        accountId + " AND building_id = (SELECT DISTINCT " + pid + " FROM Card_Product WHERE card_id = "+cardId+")").next()) {
                    statement.executeUpdate("UPDATE Account_Building SET number = number + " +
                            "(SELECT DISTINCT " + pnum + " FROM Card_Product WHERE card_id = " + cardId +" ) ");
                } else {
                    statement.executeUpdate("INSERT INTO Account_Building (account_id, building_id, number) " +
                            " VALUES (" + accountId + ", (SELECT DISTINCT " + pid + " FROM Card_Product WHERE card_id = " + cardId + "),"+
                            "(SELECT DISTINCT " + pnum + " FROM Card_Product WHERE card_id = " + cardId + "));");
                }

//                connection.commit();
            }
        }.run();
    }

    private String prepareListOfAllowCardsforAccountQuery() {
        StringBuilder q = new StringBuilder();
        q.append("select card_id ");
        q.append("from (select ");
        q.append("cp.card_id, ");
        q.append("(ar.number + cp.p1_resource_number) res_num, ");
        q.append("(ab.number + cp.p1_building_number) build_num, ");
        q.append("(au.number + cp.p1_upgrade_number) upgr_num, ");
        q.append("(anu.number + cp.necessary_upgrade_number) neces_upgr_num, ");
        q.append("(anb.number + cp.necessary_building_number) neces_build_num ");
        q.append("from Card_Product cp ");
        q.append("left join Account_Resource ar on cp.p1_resource_id = ar.resource_id ");
        q.append("left join Account_Building ab on cp.p1_building_id = ab.building_id ");
        q.append("left join Account_Upgrade au on cp.p1_upgrade_id = au.upgrade_id ");
        q.append("left join Account_Building anb on cp.necessary_building_id = anb.building_id ");
        q.append("left join Account_Upgrade anu on cp.necessary_upgrade_id = anu.upgrade_id ");
        q.append("WHERE ar.account_id = 1 ");
        q.append("group by cp.card_id ");
        q.append(" having (res_num is null or res_num >= 0) ");
        q.append("and (build_num is null or build_num >= 0) ");
        q.append("and (upgr_num is null or upgr_num >= 0) ");
        q.append("and (neces_upgr_num is null or neces_upgr_num >= 0) ");
        q.append("and (neces_build_num is null or neces_build_num >= 0) ");
        q.append(") allow_cards; ");

        return q.toString();
    }

    private String prepareListOfCardsProductQuery() {
        StringBuilder q = new StringBuilder();
        q.append("SELECT cp.id, cp.card_id, c.name 'card_name', c.description 'card_description', ");
        q.append("cp.p1_building_id, cp.p2_building_id, cp.p1_building_number, cp.p2_building_number, ");
        q.append("cp.p1_resource_id, cp.p2_resource_id, cp.p1_resource_number, cp.p2_resource_number, ");
        q.append("cp.p1_upgrade_id, cp.p1_upgrade_number, cp.p2_upgrade_number, ");
        q.append("cp.necessary_upgrade_id, cp.necessary_building_id, ");
        q.append("cp.necessary_building_number, cp.necessary_upgrade_number, ");
        q.append("b.name 'necessary_building_name', b.description 'necessary_building_description', ");
        q.append("u.name 'necessary_upgrade_name', u.description 'necessary_upgrade_description', ");
        q.append("b1.name 'p1_building_name', b1.description 'p1_building_description', ");
        q.append("b2.name 'p2_building_name', b2.description 'p2_building_description', ");
        q.append("r1.name 'p1_resource_name', r1.description 'p1_resource_description', ");
        q.append("r2.name 'p2_resource_name', r2.description 'p2_resource_description', ");
        q.append("u1.name 'p1_upgrade_name', u1.description 'p1_upgrade_description', ");
        q.append("u2.name 'p2_upgrade_name', u2.description 'p2_upgrade_description' ");
        q.append("FROM Card_Product cp ");
        q.append("LEFT JOIN Card c ON c.id = cp.card_id ");
        q.append("LEFT JOIN Building b ON b.id = cp.necessary_building_id ");
        q.append("LEFT JOIN Upgrade u ON u.id = cp.necessary_upgrade_id ");
        q.append("LEFT JOIN Building b1 ON b1.id = cp.p1_building_id ");
        q.append("LEFT JOIN Building b2 ON b2.id = cp.p2_building_id ");
        q.append("LEFT JOIN Resource r1 ON r1.id = cp.p1_resource_id ");
        q.append("LEFT JOIN Resource r2 ON r2.id = cp.p2_resource_id ");
        q.append("LEFT JOIN Upgrade u1 ON u1.id = cp.p1_upgrade_id ");
        q.append("LEFT JOIN Upgrade u2 ON u2.id = cp.p2_upgrade_id ");

        return q.toString();
    }

    private CardEntity getCardEntity(ResultSet rs) throws SQLException {
        return new CardEntity() {{
            setId(rs.getInt("card_id"));
            setName(rs.getString("card_name"));
            setDescription(rs.getString("card_description"));
        }};
    }

    private BuildingQuantityEntity getP1BuildingQuantityEntity(ResultSet rs) throws SQLException {
        return new BuildingQuantityEntity() {{
            setId(rs.getInt("id"));
            setName(rs.getString("p1_building_name"));
            setDescription(rs.getString("p1_building_description"));
            setQuantity(rs.getFloat("p1_building_number"));
        }};
    }

    private BuildingQuantityEntity getP2BuildingQuantityEntity(ResultSet rs) throws SQLException {
        return new BuildingQuantityEntity() {{
            setId(rs.getInt("id"));
            setName(rs.getString("p2_building_name"));
            setDescription(rs.getString("p2_building_description"));
            setQuantity(rs.getFloat("p2_building_number"));
        }};
    }

    private ResourceQuantityEntity getP1ResourceQuantityEntity(ResultSet rs) throws SQLException {
        return new ResourceQuantityEntity() {{
            setId(rs.getInt("id"));
            setName(rs.getString("p1_resource_name"));
            setDescription(rs.getString("p1_resource_description"));
            setQuantity(rs.getFloat("p1_resource_number"));
        }};
    }

    private ResourceQuantityEntity getP2ResourceQuantityEntity(ResultSet rs) throws SQLException {
        return new ResourceQuantityEntity() {{
            setId(rs.getInt("id"));
            setName(rs.getString("p2_resource_name"));
            setDescription(rs.getString("p2_resource_description"));
            setQuantity(rs.getFloat("p2_resource_number"));
        }};
    }

    private UpgradeQuantityEntity getP1UpgradeQuantityEntity(ResultSet rs) throws SQLException {
        return new UpgradeQuantityEntity() {{
            setId(rs.getInt("id"));
            setName(rs.getString("p1_upgrade_name"));
            setDescription(rs.getString("p1_upgrade_description"));
            setQuantity(rs.getFloat("p1_upgrade_number"));
        }};
    }

    private UpgradeQuantityEntity getP2UpgradeQuantityEntity(ResultSet rs) throws SQLException {
        return new UpgradeQuantityEntity() {{
            setId(rs.getInt("id"));
            setName(rs.getString("p2_upgrade_name"));
            setDescription(rs.getString("p2_upgrade_description"));
            setQuantity(rs.getFloat("p2_upgrade_number"));
        }};
    }

    private BuildingQuantityEntity getNecessaryBuildingQuantityEntity(ResultSet rs) throws SQLException {
        return new BuildingQuantityEntity() {{
            setId(rs.getInt("id"));
            setName(rs.getString("necessary_building_name"));
            setDescription(rs.getString("necessary_building_description"));
            setQuantity(rs.getFloat("necessary_building_number"));
        }};
    }

    private UpgradeQuantityEntity getNecessaryUpgradeQuantityEntity(ResultSet rs) throws SQLException {
        return new UpgradeQuantityEntity() {{
            setId(rs.getInt("id"));
            setName(rs.getString("necessary_upgrade_name"));
            setDescription(rs.getString("necessary_upgrade_description"));
            setQuantity(rs.getFloat("necessary_upgrade_number"));
        }};
    }

}

