package com.metacube.training.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.models.SkillsMaster;

public interface SkillsMasterRepository extends JpaRepository<SkillsMaster,Integer> {

    /**
     * Find Skills which are active
     * @param active
     * @return
     */
    public List<SkillsMaster> findByActive(boolean active);
    
    /**
     * Set Skills to Inactive
     * @param active
     * @param id
     * @return
     */
    @Transactional
    @Modifying
    @Query("UPDATE SkillsMaster SET active = ?1 WHERE skillId= ?2")
    public int setInActiveById(boolean active, int id);

}
