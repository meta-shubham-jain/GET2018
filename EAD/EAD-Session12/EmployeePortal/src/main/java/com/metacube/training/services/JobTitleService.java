package com.metacube.training.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.Status.Status;
import com.metacube.training.models.JobTitle;
import com.metacube.training.repository.JobTitleRepository;

/**
 * The class implements baseservice and implements method
 * 
 * @author Shubham Jain
 *
 */
@Service
public class JobTitleService implements BaseService<JobTitle> {

    @Autowired
    JobTitleRepository jobTitleRepository;

    @Override
    public JobTitle getById(int id) {
        return jobTitleRepository.findOne(id);
    }

    @Override
    public List<JobTitle> getAll() {
        return jobTitleRepository.findByActive(true);
    }

    @Override
    public Status create(JobTitle jobTitle) {
        jobTitleRepository.save(jobTitle);
        return Status.INSERTED;
    }

    @Override
    public Status update(JobTitle jobTitle) {
        jobTitleRepository.save(jobTitle);
        return Status.UPDATED;
    }

    @Override
    public Status delete(int id) {
        jobTitleRepository.setInActiveById(false, id);
        return Status.DELETED;
    }
}
