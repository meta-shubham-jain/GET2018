package com.metacube.training.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.Status.Status;
import com.metacube.training.dao.ProjectMasterDao;
import com.metacube.training.model.ProjectMaster;
/**
 * The class implements baseservice  and implements method
 * @author Shubham Jain
 *
 */
@Service
public class ProjectMasterService implements BaseService<ProjectMaster> {
	@Autowired
	ProjectMasterDao projectMasterDao;
	
	@Override
	public ProjectMaster getById(int id) {
        // TODO Auto-generated method stub
        return projectMasterDao.getById(id);
	}

	@Override
	public List<ProjectMaster> getAll() {
		// TODO Auto-generated method stub
		return projectMasterDao.getAll();
	}

	@Override
	public Status create(ProjectMaster projectMaster) {
		// TODO Auto-generated method stub
		Status status = projectMasterDao.create(projectMaster);
    	return status;
	}

	@Override
	public Status update(ProjectMaster projectMaster) {
		// TODO Auto-generated method stub
		return projectMasterDao.update(projectMaster);
	}

	@Override
	public Status delete(int id) {
		// TODO Auto-generated method stub
		return projectMasterDao.delete(id);
	}

}
