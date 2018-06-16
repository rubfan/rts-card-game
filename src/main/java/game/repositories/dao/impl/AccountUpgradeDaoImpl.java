package game.repositories.dao.impl;

import game.repositories.dao.AccountUpgradeDao;
import game.repositories.dao.helpers.QueryHelper;
import game.repositories.entities.AccountUpgradeEntity;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class AccountUpgradeDaoImpl implements AccountUpgradeDao {

    @Override
    public List<AccountUpgradeEntity> getListOfAccountUpgrades(int accountId) {
        return new QueryHelper<List<AccountUpgradeEntity>>(){
            @Override
            protected void executeQuery(Statement statement, Connection connection) throws SQLException {
                List<AccountUpgradeEntity> accountUpgrades = new LinkedList<>();
                ResultSet rs = statement.executeQuery(
                        "SELECT * FROM Account_Upgrade WHERE account_id = " + accountId);
                while(rs.next()) {
                    AccountUpgradeEntity accountBuilding = new AccountUpgradeEntity(
                            rs.getInt("account_id"),
                            rs.getInt("upgrade_id"),
                            rs.getInt("number")
                    );
                    accountUpgrades.add(accountBuilding);
                }
                returnResult(accountUpgrades);
            }
        }.run();
    }

    @Override
    public void cleanAccountUpgrade(int accountId) {
        new QueryHelper() {
            protected void executeQuery(Statement statement, Connection connection) throws SQLException {
                PreparedStatement pstmt = connection.prepareStatement(
                        "UPDATE Account_Upgrade SET number=0 WHERE account_id=?;");
                pstmt.setInt(1, accountId);
                int status = pstmt.executeUpdate();
                connection.commit();
            }
        }.run();
    }
}
