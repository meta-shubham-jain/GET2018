package com.metacube.training.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import com.metacube.training.models.Employee;

public interface EmployeeRepository<E> extends JpaRepository<Employee, Integer> {

    /**
     * Find Employees which are enabled
     * 
     * @param enabled
     * @return
     */
    public List<Employee> findByEnabled(boolean enabled);

    /**
     * Find Employee By Email
     * 
     * @param email
     * @return
     */
    public Employee findByEmail(String email);

    /**
     * Find Employee By Email And Password
     * 
     * @param email
     * @param password
     * @return
     */
    @Query("SELECT e from Employee e where e.email = ?1 and e.password = ?2")
    public Employee findByEmailAndPassword(String email, String password);

    /**
     * Find Employee by First and Last Name
     * 
     * @param firstName
     * @param lastName
     * @return
     */
    public List<Employee> findByFirstNameAndLastName(String firstName,
            String lastName);

    /**
     * Find Employee By Skill Id
     * 
     * @param id
     * @return
     */
    @Query("SELECT e FROM Employee e, EmployeeSkills es , SkillsMaster sm where e.empCode = es.empCode AND sm.skillId = es.skillCode AND sm.skillId = ?1")
    public List<Employee> getEmployeeBySkills(int id);

    /**
     * Find Employee by project id
     * 
     * @param projectId
     * @return
     */
    @Query("SELECT E FROM Employee e ,JobDetails j WHERE j.empCode = e.empCode AND j.projectId =?1")
    public List<Employee> getEmployeesByProjectId(int projectId);

    /**
     * Set Employee to Enabled false
     * 
     * @param enabled
     * @param empCode
     * @return
     */
    @Transactional
    @Modifying
    @Query("UPDATE Employee SET enabled = ?1 WHERE empCode = ?2")
    public int setEnabledByEmpCode(boolean enabled, int empCode);
}