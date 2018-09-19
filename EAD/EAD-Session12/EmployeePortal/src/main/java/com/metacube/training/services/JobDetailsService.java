package com.metacube.training.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.Status.Status;
import com.metacube.training.models.JobDetails;
import com.metacube.training.repository.JobDetailsRepository;

@Service
public class JobDetailsService {

    @Autowired
    private JobDetailsRepository<JobDetails> jobDetailsRepository;

    public JobDetails getById(int id) {
        return jobDetailsRepository.findOne(id);
    }

    public List<JobDetails> getAll() {
        return jobDetailsRepository.findByActive(true);
    }

    public Status create(JobDetails jobDetails) {
        jobDetailsRepository.save(jobDetails);
        return Status.INSERTED;
    }

    public Status update(JobDetails jobDetails) {
        jobDetailsRepository.save(jobDetails);
        return Status.UPDATED;
    }

    public Status delete(int id) {
        jobDetailsRepository.setInActiveById(false, id);
        return Status.DELETED;
    }
}