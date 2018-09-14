package com.metacube.training.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.metacube.training.Query.Queries;
import com.metacube.training.Status.Status;
import com.metacube.training.mappers.employeeMapper;
import com.metacube.training.model.Employee;

/**
 * The class implements basedao interface methods
 * 
 * @author Shubham Jain
 *
 */
@Service
public class EmployeeDao implements BaseDao<Employee> {
    @Autowired
    private Queries query;

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void EmployeeDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Employee getById(int code) {
        return jdbcTemplate.queryForObject(query.getEmployeeById(),
                new Object[] { code }, new employeeMapper());
    }

    @Override
    public List<Employee> getAll() {
        return jdbcTemplate
                .query(query.getAllEmployees(), new employeeMapper());
    }

    @Override
    public Status create(Employee employee) {
        int result = jdbcTemplate.update(query.getAddEmployee(),
                employee.getFirstName(), employee.getMiddleName(),
                employee.getLastName(), employee.getDob(),
                employee.getGender(), employee.getEmail(),
                employee.getPrimaryContact(), employee.getSkypeId());
        if (result > 0) {
            return Status.INSERTED;
        }
        return Status.NOT_INSERTED;
    }

    @Override
    public Status update(Employee employee) {
        int result = jdbcTemplate.update(query.getUpdateEmployee(),
                employee.getFirstName(), employee.getMiddleName(),
                employee.getLastName(), employee.getDob(),
                employee.getGender(), employee.getEmail(),
                employee.getPrimaryContact(), employee.getSkypeId(),
                employee.getEmpCode());
        if (result > 0) {
            return Status.INSERTED;
        }
        return Status.NOT_INSERTED;
    }

    @Override
    public Status delete(int id) {
        int result = jdbcTemplate.update(query.getDeleteEmployee(), id);
        if (result > 0) {
            return Status.DELETED;
        }
        return Status.NOT_DELETED;
    }

    public List<Employee> getEmployeeByName(String firstName, String lastName) {
        return jdbcTemplate.query(query.getEmployeeByName(), new Object[] {
                firstName, lastName }, new employeeMapper());
    }

    public Status checkValidCredentials(String email, String password) {
        try {
            jdbcTemplate.queryForObject(query.getEmployeByemailandPass(),
                    new Object[] { email, password }, new employeeMapper());
        } catch (EmptyResultDataAccessException e) {
            return Status.INVALID;
        }
        return Status.OK;
    }

    public Employee getEmployeeByEmail(String email) {
        try{
        return jdbcTemplate.queryForObject(query.getEmployeeByEmail(),
                new Object[] { email }, new employeeMapper());
        }catch(EmptyResultDataAccessException e){
            return null;
        }
    }
}