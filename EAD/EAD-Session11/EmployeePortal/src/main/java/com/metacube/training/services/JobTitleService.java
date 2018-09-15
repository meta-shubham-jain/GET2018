package com.metacube.training.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.Status.Status;
import com.metacube.training.dao.JobTitleDaoInterface;
import com.metacube.training.models.JobTitle;
/**
 * The class implements baseservice  and implements method
 * @author Shubham Jain
 *
 */
@Service
public class JobTitleService implements BaseService<JobTitle>{
	@Autowired
	JobTitleDaoInterface jobTitleDao;
	
	@Override
	public JobTitle getById(int id) {
		// TODO Auto-generated method stub
		return jobTitleDao.getById(id);
	}

	@Override
	public List<JobTitle> getAll() {
		// TODO Auto-generated method stub
		return jobTitleDao.getAll();
	}

	@Override
	public Status create(JobTitle entity) {
		// TODO Auto-generated method stub
		return jobTitleDao.create(entity);
	}

	@Override
	public Status update(JobTitle entity) {
		// TODO Auto-generated method stub
		return jobTitleDao.update(entity);
	}
	
	public Status delete(JobTitle jobTitle) {
		// TODO Auto-generated method stub
		return jobTitleDao.delete(jobTitle);
	}

    @Override
    public Status delete(int id) {
        // TODO Auto-generated method stub
        return null;
    }
}
