package com.metacube.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.metacube.training.models.Employee;
import com.metacube.training.models.JobDetails;
import com.metacube.training.services.EmployeeService;
import com.metacube.training.services.EmployeeSkillsService;
import com.metacube.training.services.JobDetailsService;
import com.metacube.training.services.JobTitleService;
import com.metacube.training.services.ProjectMasterService;
import com.metacube.training.services.SkillsMasterService;

/**
 * The class defines maping for all admin urls
 * 
 * @author Shubham Jain
 * 
 */
@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    SkillsMasterService skillsMasterService;

    @Autowired
    EmployeeService employeeService;

    @Autowired
    EmployeeSkillsService employeeSkillsService;

    @Autowired
    ProjectMasterService projectMasterService;

    @Autowired
    JobTitleService jobTitleService;

    @Autowired
    JobDetailsService jobDetailsService;

    /**
     * Redirecting admin to add employee page
     * 
     * @param model
     * @return
     */
    @RequestMapping(value = "/addEmployee", method = RequestMethod.GET)
    public String adminAddEmployee(Model model) {
        model.addAttribute("employee", new Employee());
        model.addAttribute("skillList", skillsMasterService.getAll());
        return "admin/addEmployee";
    }

    /**
     * It will receive request to add employee
     * 
     * @param employee
     * @param bindingResult
     * @return
     */
    @RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    public String addEmployee(@ModelAttribute("employee") Employee employee) {
        if (employee != null && employee.getEmpCode() == 0) {
            employeeService.create(employee);
            Employee employeeId = employeeService.getEmployeeByEmail(employee
                    .getEmail());
            employeeSkillsService.create(employee.getSkills(),
                    employeeId.getEmpCode());
        } else {
            employeeService.update(employee);
        }
        return "redirect:dashboard";
    }

    /**
     * It will get request to show all employees
     * 
     * @param model
     * @return
     */
    @RequestMapping(path = "/allEmployees", method = RequestMethod.GET)
    public String getAllEmployees(Model model) {
        model.addAttribute("employees", employeeService.getAll());
        return "admin/allEmployees";
    }

    /**
     * Redirecting to edit employee page
     * 
     * @param model
     * @param empCode
     * @return
     */
    @RequestMapping(path = "/editEmployee", method = RequestMethod.GET)
    public String editEmployee(Model model, @RequestParam("id") int empCode) {
        model.addAttribute("employee", employeeService.getById(empCode));
        model.addAttribute("skillList", skillsMasterService.getAll());
        return "admin/addEmployee";
    }

    /**
     * It will get request to delete employee
     * 
     * @param model
     * @param empCode
     * @return
     */
    @RequestMapping(path = "/deleteEmployee", method = RequestMethod.GET)
    public String deleteEmployee(Model model, @RequestParam("id") int empCode) {
        employeeService.delete(empCode);
        return "redirect:allEmployees";
    }

    /**
     * It will search for employee
     * 
     * @return
     */
    @GetMapping("/search")
    public String gotosearchemployee() {
        return "admin/searchEmployee";
    }

    /**
     * Redirecting to search employee page
     * 
     * @param model
     * @param firstName
     * @param lastName
     * @return
     */
    @RequestMapping(path = "/searchEmployee", method = RequestMethod.GET)
    public String searchEmployee(Model model,
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName) {
        model.addAttribute("employees",
                employeeService.getEmployeeByName(firstName, lastName));
        return "admin/searchEmployee";
    }

    /**
     * Redirect to Search Employee Page
     * 
     * @param model
     * @return
     */
    @GetMapping("/searchBySkills")
    public String gotoSearchEmployeeBySkills(Model model) {
        model.addAttribute("skillList", skillsMasterService.getAll());
        return "admin/searchEmployeeBySkills";
    }

    /**
     * Search Employee By Skills
     * 
     * @param model
     * @param skillId
     * @return
     */
    @RequestMapping(path = "/searchEmployeeBySkills", method = RequestMethod.GET)
    public String searchEmployeeBySkills(Model model,
            @RequestParam("skills") String skillId) {
        model.addAttribute("employees",
                employeeService.getEmployeeBySkills(Integer.parseInt(skillId)));
        model.addAttribute("skillList", skillsMasterService.getAll());
        return "admin/searchEmployeeBySkills";
    }

    /**
     * Redirecting to add Job Details Page
     * 
     * @param model
     * @return
     */
    @RequestMapping(value = "/addJobDetails", method = RequestMethod.GET)
    public String goToJobDetails(Model model) {
        model.addAttribute("jobDetails", new JobDetails());
        model.addAttribute("employees", employeeService.getAll());
        model.addAttribute("projectList", projectMasterService.getAll());
        model.addAttribute("jobTitleList", jobTitleService.getAll());
        return "admin/addJobDetails";
    }

    /**
     * Receive request to add job details
     * 
     * @param jobDetails
     * @return
     */
    @RequestMapping(value = "/addJobDetails", method = RequestMethod.POST)
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    public String addJobDetails(JobDetails jobDetails) {
        if (jobDetails != null && jobDetails.getJobDetailId() == 0) {
            jobDetailsService.create(jobDetails);
        } else {
            jobDetailsService.update(jobDetails);
        }
        return "redirect:dashboard";
    }

    /**
     * Redirecting to Search Employee by project page
     * 
     * @param model
     * @return
     */
    @RequestMapping(value = "/searchByProject", method = RequestMethod.GET)
    public String goToSearchProject(Model model) {
        model.addAttribute("projectList", projectMasterService.getAll());
        return "admin/searchEmployeeByProject";
    }

    /**
     * Search Employee By Project
     * 
     * @param model
     * @param projectId
     * @return
     */
    @RequestMapping(value = "/searchEmployeeByProject", method = RequestMethod.GET)
    public String searchEmployeeInProject(Model model,
            @RequestParam("projectId") int projectId) {
        model.addAttribute("projectList", projectMasterService.getAll());
        model.addAttribute("employees",
                employeeService.getEmployeesByProject(projectId));
        return "admin/searchEmployeeByProject";
    }

    /**
     * Redirecting to dashboard
     * 
     * @return
     */
    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public String gotoDashboard() {
        return "admin/dashboard";
    }
}