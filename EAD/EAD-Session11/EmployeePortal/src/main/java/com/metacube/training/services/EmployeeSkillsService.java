package com.metacube.training.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.Status.Status;
import com.metacube.training.dao.EmployeeSkillsInterface;
import com.metacube.training.models.EmployeeSkills;

@Service
public class EmployeeSkillsService implements BaseService<EmployeeSkills>{
    
    @Autowired 
    EmployeeSkillsInterface employeeSkillsDao;
    
    
    @Override
    public EmployeeSkills getById(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<EmployeeSkills> getAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Status update(EmployeeSkills entity) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Status delete(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    public Status create(String[] skills, int empCode) {
        for (String skillId : skills ) {
            EmployeeSkills employeeSkills = new EmployeeSkills();
            employeeSkills.setEmpCode(empCode);
            employeeSkills.setSkillCode(Integer.parseInt(skillId));
            employeeSkillsDao.create(employeeSkills);
        }
        return null;
    }

    @Override
    public Status create(EmployeeSkills entity) {
        // TODO Auto-generated method stub
        return null;
    }
}
