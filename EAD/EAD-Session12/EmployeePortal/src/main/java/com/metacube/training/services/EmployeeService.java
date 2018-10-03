package com.metacube.training.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.Status.Status;
import com.metacube.training.models.Employee;
import com.metacube.training.repository.EmployeeRepository;

/**
 * The class implements base service
 * 
 * @author Shubham Jain
 *
 */
@Service
public class EmployeeService implements BaseService<Employee> {

    @Autowired
    private EmployeeRepository<Employee> employeeRepository;

    @Override
    public Employee getById(int id) {
        return employeeRepository.findOne(id);
    }

    @Override
    public Status create(Employee employee) {
        employeeRepository.save(employee);
        return Status.INSERTED;
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findByEnabled(true);
    }

    @Override
    public Status update(Employee entity) {
        employeeRepository.save(entity);
        return Status.UPDATED;
    }

    @Override
    public Status delete(int empCode) {
        employeeRepository.setEnabledByEmpCode(false, empCode);
        return Status.DELETED;
    }

    public Status checkValidCredentials(String email, String password) {
        if (employeeRepository.findByEmailAndPassword(email, password) != null) {
            return Status.OK;
        }
        return Status.NOT_FOUND;
    }

    public Employee getEmployeeByEmail(String email) {
        return employeeRepository.findByEmail(email);
    }

    public List<Employee> getEmployeeBySkills(int id) {
        return employeeRepository.getEmployeeBySkills(id);
    }

    public List<Employee> getEmployeeByName(String firstName, String lastName) {
        return employeeRepository.findByFirstNameAndLastName(firstName,
                lastName);
    }

    public List<Employee> getEmployeesByProject(int projectId) {
        return employeeRepository.getEmployeesByProjectId(projectId);
    }
}