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

	/**
	 * Get job details by Id
	 * 
	 * @param id
	 * @return
	 */
	public JobDetails getById(int id) {
		return jobDetailsRepository.findOne(id);
	}

	/**
	 * Get list of all job details
	 * 
	 * @return
	 */
	public List<JobDetails> getAll() {
		return jobDetailsRepository.findByActive(true);
	}

	/**
	 * Create job details
	 * 
	 * @param jobDetails
	 * @return
	 */
	public Status create(JobDetails jobDetails) {
		jobDetailsRepository.save(jobDetails);
		return Status.INSERTED;
	}

	/**
	 * Update job details
	 * 
	 * @param jobDetails
	 * @return
	 */
	public Status update(JobDetails jobDetails) {
		jobDetailsRepository.save(jobDetails);
		return Status.UPDATED;
	}

	/**
	 * Delete Job details
	 * 
	 * @param id
	 * @return
	 */
	public Status delete(int id) {
		jobDetailsRepository.setInActiveById(false, id);
		return Status.DELETED;
	}
}