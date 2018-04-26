package game.repositories.dao.helpers;

import config.DeployDbConfig;

import java.sql.*;

/**
 * @autor ruslangramatic on 4/14/18.
 */
public abstract class QueryHelper<T> {
    private T result;
    private String connectionUrl = DeployDbConfig.DB_DATABASE_URL;

    static {
        try {
            Class.forName(DeployDbConfig.DB_DRIVER);// This will load the MySQL driver, each DB has its own driver
        } catch (ClassNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }

    protected abstract void executeQuery(Statement statement, Connection connection) throws SQLException;

    public void runWithoutDb() {
        connectionUrl = DeployDbConfig.DB_CONNECTION_URL;
        run();
    }

    public T getResult(){
        return result;
    }

    public void setResult(T result){
        this.result = result;
    }

    public T run() {
        Connection connection = null;
        try {
            // create a database connection or setup the connection with the DB
            connection = DriverManager.getConnection(connectionUrl);
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.
            executeQuery(statement, connection);
        } catch(SQLException e) {
            // if the error message is "out of memory",
            // it probably means no database file is found
            System.err.println(e.getMessage());
        } finally {
            try {
                if(connection != null)
                    connection.close();
            } catch(SQLException e) {
                // connection close failed.
                System.err.println(e);
            }
        }
        return result;
    }
}
