package com.metacube.training.dao;

import java.util.List;

import com.metacube.training.Status.Status;
import com.metacube.training.models.EmployeeSkills;

public interface EmployeeSkillsInterface {
    
    public EmployeeSkills getById(int id);

    public List<EmployeeSkills> getAll();

    public Status create(EmployeeSkills entity);

    public Status update(EmployeeSkills entity);

    public Status delete(EmployeeSkills entity);
}
