package com.dao;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

/**
 * This class is for connection to database
 * 
 * @author Shubham Jain
 *
 */
public class ConnectionToDB {
    private static final String url = "jdbc:mysql://localhost:3306/";
    private static final String dbName = "employee";
    private static final String mysqlURL = url + dbName;
    private static final String driverName = "com.mysql.jdbc.Driver";
    private static final String userName = "root";
    private static final String password = "1234";

    /**
     * Returns Connection object
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