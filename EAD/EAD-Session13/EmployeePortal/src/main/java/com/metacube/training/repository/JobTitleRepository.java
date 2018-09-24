package com.metacube.training.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.models.JobTitle;

public interface JobTitleRepository extends JpaRepository<JobTitle, Integer> {

    /**
     * Find JobTitles which are active
     * 
     * @param active
     * @return
     */
    public List<JobTitle> findByActive(boolean active);

    /**
     * Set JobTitle to InActive
     * 
     * @param active
     * @param jobCode
     * @return
     */
    @Transactional
    @Modifying
    @Query("UPDATE JobTitle SET active = ?1 WHERE jobCode= ?2")
    public int setInActiveById(boolean active, int jobCode);
}
