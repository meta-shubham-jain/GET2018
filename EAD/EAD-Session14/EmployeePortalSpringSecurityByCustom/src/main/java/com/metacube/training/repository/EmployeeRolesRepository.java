package com.metacube.training.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.metacube.training.models.EmployeeRole;

/**
 * Interface for Employee Roles Repository
 * 
 * @author Shubham Jain
 *
 * @param <E>
 */
public interface EmployeeRolesRepository extends
        JpaRepository<EmployeeRole, Integer> {
    /**
     * Find Employee Role by Email
     * 
     * @param email
     * @return
     */
    List<EmployeeRole> findByEmail(String email);
}
