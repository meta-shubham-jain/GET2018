package com.metacube.training.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.metacube.training.Status.Status;
import com.metacube.training.models.SkillsMaster;

/**
 * The class implements bas dao
 * 
 * @author Shubham Jain
 *
 */
@Repository
@Transactional
public class SkillsMasterDao implements SkillsMasterDaoInterface {
   
    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public SkillsMaster getById(int id) {
        @SuppressWarnings("deprecation")
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(SkillsMaster.class);
        criteria.add(Restrictions.eq("skillId", id));
        criteria.add(Restrictions.eq("active", true));
        return (SkillsMaster) criteria.uniqueResult();
    }

    @SuppressWarnings({ "unchecked", "deprecation" })
    @Override
    public List<SkillsMaster> getAll() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(SkillsMaster.class);
        criteria.add(Restrictions.eq("active", true));
        return criteria.list();
    }

    @Override
    public Status create(SkillsMaster skillMaster) {
        sessionFactory.getCurrentSession().save(skillMaster);
        return Status.INSERTED;
    }

    @Override
    public Status update(SkillsMaster skills) {
        sessionFactory.getCurrentSession().update(skills);
        return Status.UPDATED;
    }

    @Override
    public Status delete(SkillsMaster skills) {
        sessionFactory.getCurrentSession().update(skills);
        return Status.DELETED;
    }
}
