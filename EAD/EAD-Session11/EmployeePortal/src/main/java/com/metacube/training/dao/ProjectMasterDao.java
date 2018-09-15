package com.metacube.training.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.metacube.training.Status.Status;
import com.metacube.training.models.ProjectMaster;

@Repository
@Transactional
public class ProjectMasterDao implements ProjectMasterDaoInterface {
  
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public ProjectMaster getById(int id) {
      @SuppressWarnings("deprecation")
      Criteria criteria = sessionFactory.getCurrentSession().createCriteria(ProjectMaster.class);
      criteria.add(Restrictions.eq("projectId", id));
      criteria.add(Restrictions.eq("active", true));
      return (ProjectMaster) criteria.uniqueResult();
    }
        

    @Override
    public List<ProjectMaster> getAll() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(ProjectMaster.class);
        criteria.add(Restrictions.eq("active", true));
        return criteria.list();
    }

    @Override
    public Status create(ProjectMaster projectMaster) {
        sessionFactory.getCurrentSession().save(projectMaster);
            return Status.INSERTED;
           }

    @Override
    public Status update(ProjectMaster projectMaster) {
        sessionFactory.getCurrentSession().update(projectMaster);
        return Status.UPDATED;
    }

    @Override
    public Status delete(ProjectMaster project) {
        sessionFactory.getCurrentSession().update(project);
        return Status.DELETED;
    }
}
