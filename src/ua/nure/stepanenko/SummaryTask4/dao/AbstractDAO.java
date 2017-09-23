package ua.nure.stepanenko.SummaryTask4.dao;

import ua.nure.stepanenko.SummaryTask4.dbmanager.DBManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class AbstractDAO {
    private DBManager dbManager;

    public AbstractDAO(DBManager dbManager) {
        this.dbManager = dbManager;
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(dbManager.getConnectionString());
    }
}
