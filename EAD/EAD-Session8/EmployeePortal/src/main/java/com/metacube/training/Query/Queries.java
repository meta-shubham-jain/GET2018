package com.metacube.training.Query;

import org.springframework.stereotype.Service;

/**
 * The class defines all the queries
 * 
 * @author Shubham Jain
 *
 */
@Service
public class Queries {
    private final String ADD_EMPLOYEE = "INSERT INTO employee(first_name, middle_name, last_name, dob, gender, email, primary_contact, secondary_contact,skype_id) "
            + "VALUES " + "(?,?,?,?,?,?,?,?,?)";
    private final String getAllEmployes = "SELECT * FROM employee where enabled=1 AND active=1";
    private final String getEmployeById = "SELECT * FROM employee where emp_code=? AND enabled=1";
    private final String updateEmployee = "UPDATE employee SET first_name=?,middle_name=?,last_name=?,dob=?,gender=?,email=?,primary_contact=?,secondary_contact=?,skype_id=? WHERE emp_code=?";
    private final String deleteEmployee = "UPDATE employee SET enabled=0 WHERE emp_code=? and enabled=1";
    private final String getEmployeeByName = "SELECT * FROM employee where first_name like ? AND last_name like ? AND enabled=1";
    private final String getEmployeeByEmailAndPass = "SELECT * FROM employee where email like ? AND password=? AND enabled=1";
    private final String getEmployeeByEmail = "SELECT * FROM employee WHERE email like ?";

    // All queries of projectmaster table
    private final String ADD_PROJECT = "INSERT INTO project_master(description,start_date,end_date) VALUES (?,?,?)";
    private final String getAllProjects = "Select * from project_master WHERE active=1";
    private final String getProjectById = "Select * FROM project_master WHERE project_id=? AND active=1";
    private final String updateProject = "UPDATE project_master SET description=?,start_date=?,end_date=? WHERE project_id=? AND active=1";
    private final String deleteProject = "UPDATE project_master SET active=false WHERE project_id=?";

    // all queries of skill master table
    private final String add_Skills = "INSERT INTO skill_master(skill_name) VALUES (?)";
    private final String getAllSkills = "Select * FROM skill_master WHERE active=1";
    private final String updateSkills = "UPDATE skill_master SET skill_name=? WHERE skill_id=? AND active=1";
    private final String deletSkills = "UPDATE skill_master SET active=false WHERE skill_id=?";
    private final String getSkillById = "SELECT * FROM skill_master WHERE skill_id=? AND active=1";

    // all queries of job title table
    private final String addJobTitle = "INSERT INTO job_title (job_code,job_title) VALUES (?,?)";
    private final String getAllJobTitle = "SELECT * FROM job_title WHERE active=1";
    private final String updateJobTitle = "UPDATE job_title SET job_title=? WHERE job_code=? AND active=1";
    private final String deleteJobTitle = "Update job_title SET active=false WHERE job_code=?";
    private final String getJobtileByCode = "SELECT * FROM job_title WHERE job_code=? AND active=1";

    public String getGetAllEmployes() {
        return getAllEmployes;
    }

    public String getGetEmployeeByName() {
        return getEmployeeByName;
    }

    public String getGetEmployeById() {
        return getEmployeById;
    }

    public String getUpdateEmployee() {
        return updateEmployee;
    }

    public String getDeleteEmployee() {
        return deleteEmployee;
    }

    /**
     * @return the addJobTitle
     */
    public String getAddJobTitle() {
        return addJobTitle;
    }

    /**
     * @return the getAllJobTitle
     */
    public String getGetAllJobTitle() {
        return getAllJobTitle;
    }

    /**
     * @return the updateJobTitle
     */
    public String getUpdateJobTitle() {
        return updateJobTitle;
    }

    /**
     * @return the deleteJobTitle
     */
    public String getDeleteJobTitle() {
        return deleteJobTitle;
    }

    /**
     * @return the getJobtileByCode
     */
    public String getGetJobtileByCode() {
        return getJobtileByCode;
    }

    public String getGetAllSkills() {
        return getAllSkills;
    }

    public String getAdd_Skills() {
        return add_Skills;
    }

    public String getGetAllProjects() {
        return getAllProjects;
    }

    public String getADD_EMPLOYEE() {
        return ADD_EMPLOYEE;
    }

    public String getADD_PROJECT() {
        return ADD_PROJECT;
    }

    /**
     * @return the getProjectById
     */
    public String getGetProjectById() {
        return getProjectById;
    }

    /**
     * @return the updateProject
     */
    public String getUpdateProject() {
        return updateProject;
    }

    /**
     * @return the deleteProject
     */
    public String getDeleteProject() {
        return deleteProject;
    }

    /**
     * @return the updateSkills
     */
    public String getUpdateSkills() {
        return updateSkills;
    }

    /**
     * @return the deletSkills
     */
    public String getDeletSkills() {
        return deletSkills;
    }

    /**
     * @return the getSkillById
     */
    public String getGetSkillById() {
        return getSkillById;
    }

    public String getGetEmployeByemailandPass() {
        return getEmployeeByEmailAndPass;
    }

    public String getGetEmployeeByEmail() {
        return getEmployeeByEmail;
    }
}
