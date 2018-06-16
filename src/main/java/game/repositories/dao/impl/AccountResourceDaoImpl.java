package game.repositories.dao.impl;

import game.repositories.dao.AccountResourceDao;
import game.repositories.dao.helpers.QueryHelper;
import game.repositories.entities.AccountResourceEntity;

import java.sql.*;
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
                        "UPDATE Account_Resources SET number=0 WHERE account_id=?;");
                pstmt.setInt(1, accountId);
                int status = pstmt.executeUpdate();
                connection.commit();
            }
        }.run();

    }

}
