package com.metacube.training.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.metacube.training.Status.Status;
import com.metacube.training.models.EmployeeSkills;

@Repository
@Transactional
public class EmployeeSkillsDao implements EmployeeSkillsInterface{
    
    @Autowired
    private SessionFactory sessionFactory;
    
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
    public Status create(EmployeeSkills entity) {
        sessionFactory.getCurrentSession().save(entity);
        return Status.INSERTED;
    }

    @Override
    public Status update(EmployeeSkills entity) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Status delete(EmployeeSkills entity) {
        // TODO Auto-generated method stub
        return null;
    }

}
