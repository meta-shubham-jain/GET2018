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

    /**
     * Get project by id
     * 
     * @param id
     * @return
     */
    @Override
    public ProjectMaster getById(int id) {
        return projectMasterRepository.findOne(id);
    }

    /**
     * Get list of all projects
     * 
     * @return
     */
    @Override
    public List<ProjectMaster> getAll() {
        return projectMasterRepository.findByActive(true);
    }

    /**
     * Create project
     * 
     * @param project
     * @return
     */
    @Override
    public Status create(ProjectMaster project) {
        projectMasterRepository.save(project);
        return Status.INSERTED;
    }

    /**
     * Update project
     * 
     * @param project
     * @return
     */
    @Override
    public Status update(ProjectMaster project) {
        projectMasterRepository.save(project);
        return Status.UPDATED;
    }

    /**
     * Delete project
     * 
     * @param id
     * @return
     */
    @Override
    public Status delete(int id) {
        projectMasterRepository.setInActiveById(false, id);
        return Status.DELETED;
    }
}