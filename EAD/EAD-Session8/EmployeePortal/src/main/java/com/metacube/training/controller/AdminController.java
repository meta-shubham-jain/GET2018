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
import org.springframework.web.servlet.ModelAndView;

import com.metacube.training.models.Employee;
import com.metacube.training.models.JobTitle;
import com.metacube.training.models.ProjectMaster;
import com.metacube.training.models.SkillsMaster;
import com.metacube.training.services.EmployeeService;
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
    ProjectMasterService projectMasterService;

    @Autowired
    SkillsMasterService skillsMasterService;

    @Autowired
    EmployeeService employeeService;

    @Autowired
    JobTitleService jobTitleService;

    @GetMapping("")
    public String adminLogin() {
        return "admin/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView adminLoginDetails(@RequestParam("email") String email,
            @RequestParam("password") String password) {
        return new ModelAndView("admin/dashboard", "email", email);
    }

    @RequestMapping(value = "/addEmployee", method = RequestMethod.GET)
    public String adminAddEmployee(Model model) {
        model.addAttribute("employee", new Employee());
        model.addAttribute("skillMaster", skillsMasterService.getAll());
        return "admin/addEmployee";
    }

    @RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    public String adminAddEmployee(@ModelAttribute("employee") Employee employee) {
        if (employee != null && employee.getEmpCode() == 0) {
            employeeService.create(employee);
        } else {
            employeeService.update(employee);
        }
        return "redirect:dashboard";
    }

    @RequestMapping(path = "/allEmployees", method = RequestMethod.GET)
    public String getAllEmployees(Model model) {
        model.addAttribute("employees", employeeService.getAll());
        return "admin/allEmployees";
    }

    @RequestMapping(path = "/editEmployee", method = RequestMethod.GET)
    public String editproject(Model model, @RequestParam("id") int empCode) {
        model.addAttribute("employee", employeeService.getById(empCode));
        return "admin/addEmployee";
    }

    @RequestMapping(path = "/deleteEmployee", method = RequestMethod.GET)
    public String deleteEmployee(Model model, @RequestParam("id") int empCode) {
        employeeService.delete(empCode);
        return "redirect:allEmployees";
    }

    @GetMapping("/search")
    public String gotosearchemployee() {
        return "admin/searchEmployee";
    }

    @RequestMapping(path = "/searchEmployee", method = RequestMethod.GET)
    public String searchEmployee(Model model,
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName) {
        model.addAttribute("employees",
                employeeService.getEmployeeByName(firstName, lastName));
        return "admin/searchEmployee";
    }

    @RequestMapping(value = "/addProject", method = RequestMethod.GET)
    public String adminAddProject(Model model) {
        model.addAttribute("projectMaster", new ProjectMaster());
        return "admin/addProject";
    }

    @RequestMapping(value = "/addProject", method = RequestMethod.POST)
    public String adminAddProject(ProjectMaster projectMaster) {
        if (projectMaster != null && projectMaster.getProjectId() == 0) {
            projectMasterService.create(projectMaster);
        } else {
            projectMasterService.update(projectMaster);
        }
        return "redirect:dashboard";
    }

    @RequestMapping(path = "/allProjects", method = RequestMethod.GET)
    public String getAllProjects(Model model) {
        model.addAttribute("projects", projectMasterService.getAll());
        return "admin/allProjects";
    }

    @RequestMapping(path = "/editProject", method = RequestMethod.GET)
    public String editProject(Model model, @RequestParam("id") int projectId) {
        model.addAttribute("projectMaster",
                projectMasterService.getById(projectId));
        return "admin/addProject";
    }

    @RequestMapping(path = "/deleteProject", method = RequestMethod.GET)
    public String deleteProject(Model model, @RequestParam("id") int projectId) {
        projectMasterService.delete(projectId);
        return "redirect:allProjects";
    }

    @RequestMapping(value = "/addSkills", method = RequestMethod.GET)
    public String adminAddSkills(Model model) {
        model.addAttribute("skillsMaster", new SkillsMaster());
        return "admin/addSkills";
    }

    @RequestMapping(value = "/addSkills", method = RequestMethod.POST)
    public String adminAddSkills(SkillsMaster skillsMaster) {
        if (skillsMaster != null && skillsMaster.getSkillId() == 0) {
            skillsMasterService.create(skillsMaster);
        } else {
            skillsMasterService.update(skillsMaster);
        }
        return "redirect:dashboard";
    }

    @RequestMapping(path = "/allSkills", method = RequestMethod.GET)
    public String getAllSkills(Model model) {
        model.addAttribute("skills", skillsMasterService.getAll());
        return "admin/allSkills";
    }

    @RequestMapping(path = "/editSkills", method = RequestMethod.GET)
    public String editSkill(Model model, @RequestParam("id") int skillId) {
        model.addAttribute("skillsMaster", skillsMasterService.getById(skillId));
        return "admin/addSkills";
    }

    @RequestMapping(path = "/deleteSkill", method = RequestMethod.GET)
    public String deleteSkill(Model model, @RequestParam("id") int skillId) {
        skillsMasterService.delete(skillId);
        return "redirect:allSkills";
    }

    @RequestMapping(value = "/addJob", method = RequestMethod.GET)
    public String adminJob(Model model) {
        model.addAttribute("jobTitle", new JobTitle());
        return "admin/addJob";
    }

    @RequestMapping(value = "/addJob", method = RequestMethod.POST)
    public String adminAddJob(JobTitle jobTitle) {
        if (jobTitle != null) {
            jobTitleService.create(jobTitle);
        } else {
            jobTitleService.update(jobTitle);
        }
        return "redirect:dashboard";
    }

    @RequestMapping(path = "/allJobs", method = RequestMethod.GET)
    public String getAllJobs(Model model) {
        model.addAttribute("jobs", jobTitleService.getAll());
        return "admin/allJobs";
    }

    @RequestMapping(path = "/editJob", method = RequestMethod.GET)
    public String editJob(Model model, @RequestParam("id") int jobCode) {
        model.addAttribute("jobTitle", jobTitleService.getById(jobCode));
        return "admin/addJob";
    }

    @RequestMapping(path = "/deleteJob", method = RequestMethod.GET)
    public String deleteJob(Model model, @RequestParam("id") int jobCode) {
        jobTitleService.delete(jobCode);
        return "redirect:allJobs";
    }

    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public String gotoDashboard() {
        return "admin/dashboard";
    }
}