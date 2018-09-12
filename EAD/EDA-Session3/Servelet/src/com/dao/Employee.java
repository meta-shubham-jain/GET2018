package com.dao;

/**
 * This class contains information of employee
 * 
 * @author Shubham Jain
 *
 */
public class Employee {
    private int employeeId;
    private String firstName;
    private String lastName;
    private String email;
    private int age;

    public Employee(int employeeId, String firstName, String lastName,
            String email, int age) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
    }

    /**
     * Returns first name of employee
     * 
     * @return
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Returns last name of employee
     * 
     * @return
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Returns email address of employee
     * 
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     * Returns age of employee
     * 
     * @return
     */
    public int getAge() {
        return age;
    }

    /**
     * Returns id of employee
     * 
     * @return
     */
    public int getId() {
        return employeeId;
    }
}