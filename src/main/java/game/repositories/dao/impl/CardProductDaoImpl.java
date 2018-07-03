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
                    cardProduct.setCardGroupEntity(getCardGroupEntity(rs));
                    if (!cardProducts.containsKey(cardProduct.getCardEntity().getId())) {
                        cardProduct.setId(rs.getInt("id"));
                        cardProducts.put(cardProduct.getCardEntity().getId(), cardProduct);
                    } else {
                        cardProduct = cardProducts.get(cardProduct.getCardEntity().getId());
                    }
                    addP1BuildingQuantityEntity(rs, cardProduct);
                    addP2BuildingQuantityEntity(rs, cardProduct);
                    addP1ResourceQuantityEntity(rs, cardProduct);
                    addP2ResourceQuantityEntity(rs, cardProduct);
                    addP1UpgradeQuantityEntity(rs, cardProduct);
                    addP2UpgradeQuantityEntity(rs, cardProduct);
                    addNecessaryBuildingQuantityEntity(rs, cardProduct);
                    addNecessaryUpgradeQuantityEntity(rs, cardProduct);
                }
                if (cardProducts.size() > 0) {
                    returnResult(cardProducts.values());
                }
            }
        }.run();
    }

    @Override
    public List<Integer> getAllowAccountCards(Integer accountId) {
        return new QueryHelper<List<Integer>>() {
            protected void executeQuery(Statement statement, Connection connection) throws SQLException {
                List<Integer> allowCards = new LinkedList<>();
                ResultSet rs = statement.executeQuery(prepareListOfAllowCardsForAccountQuery(accountId));
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
        new QueryHelper() {
            protected void executeQuery(Statement statement, Connection connection) throws SQLException {
                statement.executeUpdate(prepareApplyCard(accountId, cardId));
            }
        }.run();
    }

    private String prepareApplyCard(Integer accountId, Integer cardId){
        StringBuilder q = new StringBuilder();
        String card = cardId.toString();
        String playerOne, playerTwo;
        if (accountId.equals(1)){
            playerOne = "1";
            playerTwo = "2";
        } else {
            playerOne = "2";
            playerTwo = "1";
        }

        q.append("UPDATE (SELECT ");
        q.append("cp.card_id cardId, cp.p1_building_id p1BId, cp.p2_building_id p2BId, ");
        q.append("cp.p1_building_number p1BNum, cp.p2_building_number p2BNum, ");
        q.append("cp.p1_resource_id p1RId, cp.p2_resource_id p2RId, ");
        q.append("cp.p1_resource_number p1RNum, cp.p2_resource_number p2RNum, ");
        q.append("cp.p1_upgrade_id p1UId, cp.p2_upgrade_id p2UId, ");
        q.append("cp.p1_upgrade_number p1UNum, cp.p2_upgrade_number p2UNum, ");
        q.append("ab1.account_id bAccId, ab1.building_id bBildId, ab1.number bNum, ");
        q.append("ar1.account_id rAccId, ar1.resource_id rResId, ar1.number rNum, ");
        q.append("au1.account_id uAccId, au1.upgrade_id uUpId, au1.number uNum, ");
        q.append("(p1_building_number + ab1.number) p1_building_summary, ");
        q.append("(p2_building_number + ab2.number) p2_building_summary, ");
        q.append("(p1_resource_number + ar1.number) p1_resource_summary, ");
        q.append("(p2_resource_number + ar2.number) p2_resource_summary, ");
        q.append("(p1_upgrade_number + au1.number) p1_upgrade_summary, ");
        q.append("(p2_upgrade_number + au2.number) p2_upgrade_summary ");
        q.append("FROM Card_Product cp ");
        q.append("LEFT JOIN Account_Building ab1 ON ab1.building_id = cp.p1_building_id ");
        q.append("LEFT JOIN Account_Building ab2 ON ab2.building_id = cp.p2_building_id ");
        q.append("LEFT JOIN Account_Resource ar1 ON ar1.resource_id = cp.p1_resource_id ");
        q.append("LEFT JOIN Account_Resource ar2 ON ar2.resource_id = cp.p2_resource_id ");
        q.append("LEFT JOIN Account_Upgrade au1 ON au1.upgrade_id = cp.p1_upgrade_id ");
        q.append("LEFT JOIN Account_Upgrade au2 ON au2.upgrade_id = cp.p2_upgrade_id ");
        q.append("WHERE cp.card_id = ");
        q.append(card);
        q.append(" group by p1_building_id, p2_building_id, p1_resource_id, p2_resource_id, p1_upgrade_id, p2_upgrade_id) result ");
        q.append("LEFT JOIN Account_Building ab1 ON ab1.building_id = result.p1BId ");
        q.append("LEFT JOIN Account_Building ab2 ON ab2.building_id = result.p2BId ");
        q.append("LEFT JOIN Account_Resource ar1 ON ar1.resource_id = result.p1RId ");
        q.append("LEFT JOIN Account_Resource ar2 ON ar2.resource_id = result.p2RId ");
        q.append("LEFT JOIN Account_Upgrade au1 ON au1.upgrade_id = result.p1UId ");
        q.append("LEFT JOIN Account_Upgrade au2 ON au2.upgrade_id = result.p2UId ");
        q.append("SET ");
        q.append("ab1.number = IF(ab1.account_id = " + playerOne +
                " AND result.p1_building_summary is not null, result.p1_building_summary, ab1.number), ");
        q.append("ab2.number = IF(ab2.account_id = " + playerTwo +
                " AND result.p2_building_summary is not null, result.p2_building_summary, ab2.number), ");
        q.append("ar1.number = IF(ar1.account_id = " + playerOne +
                " AND result.p1_resource_summary is not null, result.p1_resource_summary, ar1.number), ");
        q.append("ar2.number = IF(ar2.account_id = " + playerTwo +
                " AND result.p2_resource_summary is not null, result.p2_resource_summary, ar2.number), ");
        q.append("au1.number = IF(au1.account_id = " + playerOne +
                " AND result.p1_upgrade_summary is not null, result.p1_upgrade_summary, au1.number), ");
        q.append("au2.number = IF(au2.account_id = " + playerTwo +
                " AND result.p2_upgrade_summary is not null, result.p2_upgrade_summary, au2.number) ");
        q.append("WHERE ab1.account_id = " + playerOne +
                " OR ab2.account_id = " + playerTwo + " ");

        return q.toString();
    }

    private String prepareListOfAllowCardsForAccountQuery(Integer accountId) {
        StringBuilder q = new StringBuilder();
        q.append("select card_id ");
        q.append("from (select ");
        q.append("cp.card_id, ");
        q.append("SUM(ar.number + cp.p1_resource_number) res_num, ");
        q.append("SUM(ab.number + cp.p1_building_number) build_num, ");
        q.append("SUM(au.number + cp.p1_upgrade_number) upgr_num, ");
        q.append("SUM(anu.number + cp.necessary_upgrade_number) neces_upgr_num, ");
        q.append("SUM(anb.number + cp.necessary_building_number) neces_build_num ");
        q.append("from Card_Product cp ");
        q.append("left join Account_Resource ar on cp.p1_resource_id = ar.resource_id ");
        q.append("left join Account_Building ab on cp.p1_building_id = ab.building_id ");
        q.append("left join Account_Upgrade au on cp.p1_upgrade_id = au.upgrade_id ");
        q.append("left join Account_Building anb on cp.necessary_building_id = anb.building_id ");
        q.append("left join Account_Upgrade anu on cp.necessary_upgrade_id = anu.upgrade_id ");
        q.append("WHERE ar.account_id = " + accountId + " ");
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
        q.append("cp.card_group_id, cg.name 'card_group_name', cg.description 'card_group_description', ");
        q.append("cp.p1_building_id, cp.p2_building_id, cp.p1_building_number, cp.p2_building_number, ");
        q.append("cp.p1_resource_id, cp.p2_resource_id, cp.p1_resource_number, cp.p2_resource_number, ");
        q.append("cp.p1_upgrade_id, cp.p2_upgrade_id, cp.p1_upgrade_number, cp.p2_upgrade_number, ");
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
        q.append("LEFT JOIN Card_Group cg ON cg.id = cp.card_group_id ");
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
    private CardGroupEntity getCardGroupEntity(ResultSet rs) throws SQLException {
        return new CardGroupEntity() {{
            setId(rs.getInt("card_group_id"));
            setName(rs.getString("card_group_name"));
            setDescription(rs.getString("card_group_description"));
        }};
    }

    private void addP1BuildingQuantityEntity(ResultSet rs, CardProductEntity cardProduct) throws SQLException {
        Float num = rs.getFloat("p1_building_number");
        if (num == 0) return;
        if (cardProduct.getP1BuildingQuantityEntityList() == null){
            cardProduct.setP1BuildingQuantityEntityList(new LinkedList<>());
        }
        cardProduct.getP1BuildingQuantityEntityList().add(
        new BuildingQuantityEntity() {{
            setId(rs.getInt("p1_building_id"));
            setName(rs.getString("p1_building_name"));
            setDescription(rs.getString("p1_building_description"));
            setQuantity(rs.getFloat("p1_building_number"));
        }});
    }

    private void addP2BuildingQuantityEntity(ResultSet rs, CardProductEntity cardProduct) throws SQLException {
        Float num = rs.getFloat("p2_building_number");
        if (num == 0) return;
        if (cardProduct.getP2BuildingQuantityEntityList() == null){
            cardProduct.setP2BuildingQuantityEntityList(new LinkedList<>());
        }
        cardProduct.getP2BuildingQuantityEntityList().add(
        new BuildingQuantityEntity() {{
            setId(rs.getInt("p2_building_id"));
            setName(rs.getString("p2_building_name"));
            setDescription(rs.getString("p2_building_description"));
            setQuantity(rs.getFloat("p2_building_number"));
        }});
    }

    private void addP1ResourceQuantityEntity(ResultSet rs, CardProductEntity cardProduct) throws SQLException {
        Float num = rs.getFloat("p1_resource_number");
        if (num == 0) return;
        if (cardProduct.getP1ResourceQuantityEntityList() == null){
            cardProduct.setP1ResourceQuantityEntityList(new LinkedList<>());
        }
        cardProduct.getP1ResourceQuantityEntityList().add(
        new ResourceQuantityEntity() {{
            setId(rs.getInt("p1_resource_id"));
            setName(rs.getString("p1_resource_name"));
            setDescription(rs.getString("p1_resource_description"));
            setQuantity(rs.getFloat("p1_resource_number"));
        }});
    }

    private void addP2ResourceQuantityEntity(ResultSet rs, CardProductEntity cardProduct) throws SQLException {
        Float num = rs.getFloat("p2_resource_number");
        if (num == 0) return;
        if (cardProduct.getP2ResourceQuantityEntityList() == null){
            cardProduct.setP2ResourceQuantityEntityList(new LinkedList<>());
        }
        cardProduct.getP2ResourceQuantityEntityList().add(
        new ResourceQuantityEntity() {{
            setId(rs.getInt("p2_resource_id"));
            setName(rs.getString("p2_resource_name"));
            setDescription(rs.getString("p2_resource_description"));
            setQuantity(rs.getFloat("p2_resource_number"));
        }});
    }

    private void addP1UpgradeQuantityEntity(ResultSet rs, CardProductEntity cardProduct) throws SQLException {
        Float num = rs.getFloat("p1_upgrade_number");
        if (num == 0) return;
        if (cardProduct.getP1UpgradeQuantityEntityList() == null){
            cardProduct.setP1UpgradeQuantityEntityList(new LinkedList<>());
        }
        cardProduct.getP1UpgradeQuantityEntityList().add(
        new UpgradeQuantityEntity() {{
            setId(rs.getInt("p1_upgrade_id"));
            setName(rs.getString("p1_upgrade_name"));
            setDescription(rs.getString("p1_upgrade_description"));
            setQuantity(rs.getFloat("p1_upgrade_number"));
        }});
    }

    private void addP2UpgradeQuantityEntity(ResultSet rs, CardProductEntity cardProduct) throws SQLException {
        Float num = rs.getFloat("p2_upgrade_number");
        if (num == 0) return;
        if (cardProduct.getP2UpgradeQuantityEntityList() == null){
            cardProduct.setP2UpgradeQuantityEntityList(new LinkedList<>());
        }
        cardProduct.getP2UpgradeQuantityEntityList().add(
        new UpgradeQuantityEntity() {{
            setId(rs.getInt("p2_upgrade_id"));
            setName(rs.getString("p2_upgrade_name"));
            setDescription(rs.getString("p2_upgrade_description"));
            setQuantity(rs.getFloat("p2_upgrade_number"));
        }});
    }

    private void addNecessaryBuildingQuantityEntity(ResultSet rs, CardProductEntity cardProduct) throws SQLException {
        Float num = rs.getFloat("necessary_building_number");
        if (num == 0) return;
        if (cardProduct.getNecessaryBuildingQuantityEntityList() == null){
            cardProduct.setNecessaryBuildingQuantityEntityList(new LinkedList<>());
        }
        cardProduct.getNecessaryBuildingQuantityEntityList().add(
        new BuildingQuantityEntity() {{
            setId(rs.getInt("necessary_building_id"));
            setName(rs.getString("necessary_building_name"));
            setDescription(rs.getString("necessary_building_description"));
            setQuantity(rs.getFloat("necessary_building_number"));
        }});
    }

    private void addNecessaryUpgradeQuantityEntity(ResultSet rs, CardProductEntity cardProduct) throws SQLException {
        Float num = rs.getFloat("necessary_upgrade_number");
        if (num == 0) return;
        if (cardProduct.getNecessaryUpgradeQuantityEntityList() == null){
            cardProduct.setNecessaryUpgradeQuantityEntityList(new LinkedList<>());
        }
        cardProduct.getNecessaryUpgradeQuantityEntityList().add(
        new UpgradeQuantityEntity() {{
            setId(rs.getInt("necessary_upgrade_id"));
            setName(rs.getString("necessary_upgrade_name"));
            setDescription(rs.getString("necessary_upgrade_description"));
            setQuantity(rs.getFloat("necessary_upgrade_number"));
        }});
    }

}

