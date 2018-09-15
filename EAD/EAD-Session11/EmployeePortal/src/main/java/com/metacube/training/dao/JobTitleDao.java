package com.metacube.training.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.metacube.training.Status.Status;
import com.metacube.training.models.JobTitle;

/**
 * The class implements method basedao and implements it
 * 
 * @author Shubham Jain
 *
 */
@Repository
@Transactional
public class JobTitleDao implements JobTitleDaoInterface {
    
    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public JobTitle getById(int id) {
        @SuppressWarnings("deprecation")
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(JobTitle.class);
        criteria.add(Restrictions.eq("jobCode", id));
        criteria.add(Restrictions.eq("active", true));
        return (JobTitle) criteria.uniqueResult();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<JobTitle> getAll() {
        @SuppressWarnings("deprecation")
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(JobTitle.class);
        criteria.add(Restrictions.eq("active", true));
        return criteria.list();
    }

    @Override
    public Status create(JobTitle jobTitle) {
        sessionFactory.getCurrentSession().save(jobTitle);
        return Status.INSERTED;
    }

    @Override
    public Status update(JobTitle jobTitle) {
        sessionFactory.getCurrentSession().update(jobTitle);
        return Status.UPDATED;
    }

    @Override
    public Status delete(JobTitle jobTitle) {
        sessionFactory.getCurrentSession().update(jobTitle);
        return Status.DELETED;
    }
}