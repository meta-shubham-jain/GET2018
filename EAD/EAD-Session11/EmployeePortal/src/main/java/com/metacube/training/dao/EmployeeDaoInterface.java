package com.metacube.training.dao;

import java.util.List;

import com.metacube.training.Status.Status;
import com.metacube.training.models.Employee;

public interface EmployeeDaoInterface {
    
    public Employee getById(int id);

    public List<Employee> getAll();

    public Status create(Employee entity);

    public Status update(Employee entity);

    public Status delete(Employee entity);

    public List<Employee> getEmployeeByName(String firstName, String lastName);

    public Employee getEmployeeByEmail(String email);

    public Status checkValidCredentials(String email, String password);

    public Employee getEmployeeMaxId();

    public List<Employee> getEmployeeBySkills(int id);
}
