package com.metacube.training.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.Status.Status;
import com.metacube.training.models.ProjectMaster;
import com.metacube.training.repository.ProjectMasterRepository;

/**
 * The class implements baseservice and implements method
 * 
 * @author Shubham Jain
 *
 */
@Service
public class ProjectMasterService implements BaseService<ProjectMaster> {

    @Autowired
    ProjectMasterRepository projectMasterRepository;

    @Override
    public ProjectMaster getById(int id) {
        return projectMasterRepository.findOne(id);
    }

    @Override
    public List<ProjectMaster> getAll() {
        return projectMasterRepository.findByActive(true);
    }

    @Override
    public Status create(ProjectMaster project) {
        projectMasterRepository.save(project);
        return Status.INSERTED;
    }

    @Override
    public Status update(ProjectMaster project) {
        projectMasterRepository.save(project);
        return Status.UPDATED;
    }

    @Override
    public Status delete(int id) {
        projectMasterRepository.setInActiveById(false, id);
        return Status.DELETED;
    }
}
