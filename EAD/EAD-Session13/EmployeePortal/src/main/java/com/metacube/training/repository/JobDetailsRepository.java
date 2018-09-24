package com.metacube.training.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.models.JobDetails;

/**
 * Interface for Job Details Repository
 * 
 * @author Shubham Jain
 *
 * @param <E>
 */
public interface JobDetailsRepository<E> extends
        JpaRepository<JobDetails, Integer> {

    /**
     * Find JobDetails which are active
     * 
     * @param active
     * @return
     */
    public List<JobDetails> findByActive(boolean active);

    /**
     * Set Jobdetials to In active
     * 
     * @param active
     * @param projectId
     * @return
     */
    @Transactional
    @Modifying
    @Query("UPDATE JobDetails SET active = ?1 WHERE jobDetailId= ?2")
    int setInActiveById(boolean active, int projectId);
}