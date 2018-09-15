package com.metacube.training.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.Status.Status;
import com.metacube.training.dao.ProjectMasterDaoInterface;
import com.metacube.training.models.ProjectMaster;
/**
 * The class implements baseservice  and implements method
 * @author Shubham Jain
 *
 */
@Service
public class ProjectMasterService implements BaseService<ProjectMaster> {
	@Autowired
	ProjectMasterDaoInterface projectMasterDao;
	
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

	public Status delete(ProjectMaster project) {
		// TODO Auto-generated method stub
		return projectMasterDao.delete(project);
	}

    @Override
    public Status delete(int id) {
        // TODO Auto-generated method stub
        return null;
    }

}
