package com.metacube.training.dao;

import java.util.List;

import com.metacube.training.Status.Status;
import com.metacube.training.models.ProjectMaster;

public interface ProjectMasterDaoInterface {

    public ProjectMaster getById(int id);

    public List<ProjectMaster> getAll();

    public Status create(ProjectMaster entity);

    public Status update(ProjectMaster entity);

    public Status delete(ProjectMaster project);
}