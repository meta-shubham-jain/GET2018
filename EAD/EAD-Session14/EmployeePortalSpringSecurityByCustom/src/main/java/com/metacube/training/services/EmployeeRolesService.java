package com.metacube.training.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.metacube.training.models.EmployeeRole;
import com.metacube.training.repository.EmployeeRolesRepository;

/**
 * Service class for Employee Roles
 * 
 * @author Shubham Jain
 *
 */
@Service
public class EmployeeRolesService {

    @Autowired
    private EmployeeRolesRepository employeeRoleRepository;

    /**
     * Get List of Employee by Email
     * 
     * @param email
     * @return
     */
    public List<EmployeeRole> getRoleByEmail(String email) {
        return employeeRoleRepository.findByEmail(email);
    }
}
