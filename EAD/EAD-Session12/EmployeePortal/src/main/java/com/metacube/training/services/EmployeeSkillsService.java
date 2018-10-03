package com.metacube.training.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.Status.Status;
import com.metacube.training.models.EmployeeSkills;
import com.metacube.training.repository.EmployeeSkillsRepository;

@Service
public class EmployeeSkillsService implements BaseService<EmployeeSkills> {

    @Autowired
    EmployeeSkillsRepository employeeSkillsRepository;

    @Override
    public EmployeeSkills getById(int id) {
        return employeeSkillsRepository.findOne(id);
    }

    @Override
    public List<EmployeeSkills> getAll() {
        return employeeSkillsRepository.findAll();
    }

    public Status create(String[] skills, int empCode) {
        for (String skillId : skills) {
            EmployeeSkills employeeSkills = new EmployeeSkills();
            employeeSkills.setEmpCode(empCode);
            employeeSkills.setSkillCode(Integer.parseInt(skillId));
            employeeSkillsRepository.save(employeeSkills);
        }
        return Status.INSERTED;
    }

    @Override
    public Status update(EmployeeSkills entity) {
        employeeSkillsRepository.save(entity);
        return Status.UPDATED;
    }

    @Override
    public Status delete(int id) {
        return null;
    }

    @Override
    public Status create(EmployeeSkills entity) {
        return null;
    }
}