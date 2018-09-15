package com.metacube.training.dao;

import java.util.List;

import com.metacube.training.Status.Status;
import com.metacube.training.models.JobTitle;

public interface JobTitleDaoInterface {
    
    public JobTitle getById(int id);

    public List<JobTitle> getAll();

    public Status create(JobTitle entity);

    public Status update(JobTitle entity);

    public Status delete(JobTitle entity);
}
