package com.dao;

/**
 * This class has queries of application
 * 
 * @author Shubham Jain
 *
 */
public class Queries {
    private static final String addEmployeeQuery = "INSERT INTO employee(first_name,last_name,email,age) VALUES(?,?,?,?)";
    private static final String showEmployeeDetailsQuery = "SELECT * FROM employee";
    private static final String searchEmployeeQuery = "SELECT * FROM employee WHERE first_name = ? AND last_name = ?";
    private static final String updateEmployeeDetailsQuery = "SELECT * FROM employee WHERE employee_id = ?";
    private static final String updateEmployeeQuery = "UPDATE employee SET first_name = ? , last_name = ? , email = ? , age = ? WHERE employee_id = ?";

    /**
     * Returns add Employee Query
     * 
     * @return
     */
    public static String getAddEmployeeQuery() {
        return addEmployeeQuery;
    }

    /**
     * Returns show employee details query
     * 
     * @return
     */
    public static String getShowEmployeeDetailsQuery() {
        return showEmployeeDetailsQuery;
    }

    /**
     * Returns search employee query
     * 
     * @return
     */
    public static String getSearchEmployeeQuery() {
        return searchEmployeeQuery;
    }

    /**
     * Returns update employee query
     * 
     * @return
     */
    public static String getUpdateEmployeeDetailsQuery() {
        return updateEmployeeDetailsQuery;
    }

    /**
     * Returns update details employee query
     * 
     * @return
     */
    public static String getUpdateEmployeeQuery() {
        return updateEmployeeQuery;
    }
}