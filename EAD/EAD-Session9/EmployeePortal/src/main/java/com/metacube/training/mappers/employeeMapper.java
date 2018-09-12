package com.metacube.training.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.training.models.Employee;

public class employeeMapper implements RowMapper<Employee> {

    @Override
    public Employee mapRow(ResultSet resultSet, int arg1) throws SQLException {
        Employee employee = new Employee();
        employee.setEmpCode(resultSet.getInt("emp_code"));
        employee.setFirstName(resultSet.getString("first_name"));
        employee.setMiddleName(resultSet.getString("middle_name"));
        employee.setLastName(resultSet.getString("last_name"));
        employee.setDob(resultSet.getDate("dob"));
        employee.setGender(resultSet.getString("gender"));
        employee.setEmail(resultSet.getString("email"));
        employee.setPrimaryContact(resultSet.getString("primary_contact"));
        employee.setSecondaryContact(resultSet.getString("secondary_contact"));
        employee.setSkypeId(resultSet.getString("skype_id"));
        employee.setPassword(resultSet.getString("password"));
        employee.setProfilePicture(resultSet.getString("profile_picture"));
        return employee;
    }
}
