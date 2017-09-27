package ua.nure.stepanenko.SummaryTask4.dbmanager;

import ua.nure.stepanenko.SummaryTask4.exceptions.DBConnectException;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {
    private String connectionString;

    private static DBManager manager;

    private DBManager() throws DBConnectException {
        connectionString = "jdbc:mysql://localhost/pentatours";

        try {
            Driver driver = new com.mysql.jdbc.Driver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            throw new DBConnectException();
        }
    }

    public synchronized static DBManager getInstance() throws DBConnectException {
        if(manager == null) {
            manager = new DBManager();
        }
        return manager;
    }

    public String getConnectionString() {
        return connectionString;
    }
}
