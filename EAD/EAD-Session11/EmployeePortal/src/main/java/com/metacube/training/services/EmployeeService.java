package com.metacube.training.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.Status.Status;
import com.metacube.training.dao.EmployeeDaoInterface;
import com.metacube.training.models.Employee;
/**
 * The class implements base service
 * @author Shubham Jain
 *
 */
@Service
public class EmployeeService implements BaseService<Employee>{
	
    @Autowired 
	EmployeeDaoInterface employeeDao;
    
	public List<Employee> getEmployeeByName(String firstName,String lastName) {
		return employeeDao.getEmployeeByName(firstName,lastName);
	}
	
	@Override
	public Employee getById(int id) {
		// TODO Auto-generated method stub
		return employeeDao.getById(id);
	}

	@Override
	public List<Employee> getAll() {
		// TODO Auto-generated method stub
		return employeeDao.getAll();
	}

	@Override
	public Status create(Employee employee) {
		// TODO Auto-generated method stub
		Status status = employeeDao.create(employee);
        return status;
	}

	@Override
	public Status update(Employee entity) {
		// TODO Auto-generated method stub
		return employeeDao.update(entity);
	}
	
	public Status delete(Employee employee) {
		// TODO Auto-generated method stub
		return employeeDao.delete(employee);
	}

	public Status checkValidCredentials(String email, String password) {
		// TODO Auto-generated method stub
		return employeeDao.checkValidCredentials(email,password);
	}
	
	public Employee getEmployeeByEmail(String email) {
		return employeeDao.getEmployeeByEmail(email);
	}
	
	public Employee getEmployeeByMaxId() {
	    return employeeDao.getEmployeeMaxId();
	}

    @Override
    public Status delete(int id) {
        // TODO Auto-generated method stub
        return null;
    }
    
    public List<Employee> getEmployeeBySkills(int id) {
        return employeeDao.getEmployeeBySkills(id);
    }
}
