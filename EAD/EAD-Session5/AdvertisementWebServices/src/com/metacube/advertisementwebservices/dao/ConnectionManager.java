package com.metacube.advertisementwebservices.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Connection class for JDBC Connectivity
 */
public class ConnectionManager {
    private static final String url = "jdbc:mysql://localhost:3306/";
    private static final String dbName = "category_advertisement";
    private static final String mysqlURL = url + dbName;
    private static final String driverName = "com.mysql.jdbc.Driver";
    private static final String userName = "root";
    private static final String password = "1234";

    /**
     * Function to create connection with database
     * 
     * @return
     */
    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(driverName);
            try {
                connection = (Connection) DriverManager.getConnection(mysqlURL,
                        userName, password);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return connection;
    }
}