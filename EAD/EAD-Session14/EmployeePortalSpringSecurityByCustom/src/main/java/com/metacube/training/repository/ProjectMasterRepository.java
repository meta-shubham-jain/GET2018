package com.metacube.training.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import com.metacube.training.models.ProjectMaster;

/**
 * Interface for Project Master Repository
 * 
 * @author Shubham Jain
 *
 * @param <E>
 */
public interface ProjectMasterRepository extends
        JpaRepository<ProjectMaster, Integer> {

    /**
     * Find Projects which are active
     * 
     * @param active
     * @return
     */
    List<ProjectMaster> findByActive(boolean active);

    /**
     * Set Project to Inactive
     * 
     * @param active
     * @param projectId
     * @return
     */
    @Transactional
    @Modifying
    @Query("UPDATE ProjectMaster SET active = ?1 WHERE projectId= ?2")
    int setInActiveById(boolean active, int projectId);
}
