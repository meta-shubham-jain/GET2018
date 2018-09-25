package com.metacube.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.metacube.training.models.EmployeeSkills;

/**
 * Interface for Employee Skills Repository
 * 
 * @author Shubham Jain
 *
 * @param <E>
 */
public interface EmployeeSkillsRepository extends
        JpaRepository<EmployeeSkills, Integer> {

}
