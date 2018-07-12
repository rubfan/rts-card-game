package game.repositories.dao.impl;

import game.repositories.dao.AccountResourceDao;
import game.repositories.dao.helpers.QueryHelper;
import game.repositories.entities.AccountResourceEntity;
import game.repositories.entities.AccountResourceQuantityEntity;

import java.sql.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class AccountResourceDaoImpl implements AccountResourceDao {

    @Override
    public List<AccountResourceEntity> getListOfAccountResources(Integer accountId) {
        return new QueryHelper<List<AccountResourceEntity>>(){
            @Override
            protected void executeQuery(Statement statement, Connection connection) throws SQLException {
                List<AccountResourceEntity> accountResources = new LinkedList<>();
                ResultSet rs = statement.executeQuery(
                        "SELECT * FROM Account_Resource WHERE account_id = " + accountId);
                while(rs.next()) {
                    AccountResourceEntity accountResource = new AccountResourceEntity(
                            rs.getInt("account_id"),
                            rs.getInt("resource_id"),
                            rs.getInt("number")
                    );
                    accountResources.add(accountResource);
                }
                returnResult(accountResources);
            }
        }.run();
    }

    @Override
    public void cleanAccountResourses(int accountId) {
        new QueryHelper() {
            protected void executeQuery(Statement statement, Connection connection) throws SQLException {
                PreparedStatement pstmt = connection.prepareStatement(
                        "UPDATE Account_Resource SET number=0 WHERE account_id=? AND NOT resource_id = IN(1,2);");
                pstmt.setInt(1, accountId);
                int status = pstmt.executeUpdate();
                connection.commit();
            }
        }.run();

    }

    @Override
    public List<AccountResourceQuantityEntity> getAccountResourcesQuantity(Integer accountId, Long deltaTimeSeconds){
        return new QueryHelper<List<AccountResourceQuantityEntity>>() {
            protected void executeQuery(Statement statement, Connection connection) throws SQLException {
                List<AccountResourceQuantityEntity> accountResourceQuantityList = new LinkedList<>();
                try {
                    //Assume a valid connection object conn
                    connection.setAutoCommit(false);

                    ResultSet rs = statement.executeQuery(prepareListOfAllowCardsForAccountQuery(accountId));
                    while (rs.next()) {
                        AccountResourceQuantityEntity accountResourceQuantity = new AccountResourceQuantityEntity(
                                rs.getInt("resource_id" ),
                                rs.getInt("number" ),
                                rs.getInt("res_per_min" ));
                        accountResourceQuantityList.add(accountResourceQuantity);
                    }
                    if (accountResourceQuantityList.size() > 0) {
                        returnResult(accountResourceQuantityList);
                    } else {
                        returnResult(Collections.emptyList());
                    }

                    AccountResourceQuantityEntity[] accountResourceQuantityEntities =
                            accountResourceQuantityList.toArray(new AccountResourceQuantityEntity[accountResourceQuantityList.size()]);
                    for (int i = 0; i < accountResourceQuantityList.size(); i++) {
                        statement.executeUpdate("UPDATE Account_Resource SET number = number * 1.1 WHERE resource_id = "
                                + accountResourceQuantityEntities[i].getResourceId()+" AND account_id =" + accountId);
                    }

                    connection.commit();

                } catch(SQLException se){
                // If there is any error.
                connection.rollback();
            }
            }
        }.run();
    }

    private String prepareListOfAllowCardsForAccountQuery(Integer accountId) {
        StringBuilder q = new StringBuilder();
        q.append("SELECT ar.resource_id, ar.number, SUM(ab.number * bp.number_per_sec + ab.number / 100 * up.percent) res_per_min ");
        q.append("FROM Account_Resource ar ");
        q.append("LEFT JOIN Account_Building ab ON ar.account_id = ab.account_id ");
        q.append("LEFT JOIN Account_Upgrade au ON ar.account_id = au.account_id ");
        q.append("LEFT JOIN Building_Product bp ON bp.building_id = ab.building_id ");
        q.append("LEFT JOIN Upgrade_Product up ON up.upgrade_id = au.upgrade_id ");
        q.append("WHERE ar.account_id = " + accountId +
                 " AND ab.account_id = " + accountId);
        q.append(" AND bp.resource_id = ar.resource_id AND ab.building_id = bp.building_id ");
        q.append("GROUP BY bp.resource_id ");
        return q.toString();
    }

}
