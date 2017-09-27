package ua.nure.stepanenko.SummaryTask4.dao;

import ua.nure.stepanenko.SummaryTask4.dbmanager.DBManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public abstract class AbstractDAO {
    private DBManager dbManager;

    public AbstractDAO(DBManager dbManager) {
        this.dbManager = dbManager;
    }

    public Connection getConnection() throws SQLException {
        String user = "root";
        String password = "FjRbct69";

        Properties p = new Properties();
        p.setProperty("user", user);
        p.setProperty("password", password);
        p.setProperty("useUnicode","true");
        p.setProperty("characterEncoding", "UTF-8");
        return DriverManager.getConnection(dbManager.getConnectionString(), p);
    }
}
