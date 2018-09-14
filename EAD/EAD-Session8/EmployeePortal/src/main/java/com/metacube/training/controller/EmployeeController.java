package com.metacube.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.metacube.training.Status.Status;
import com.metacube.training.models.Employee;
import com.metacube.training.services.EmployeeService;
import com.metacube.training.services.JobTitleService;
import com.metacube.training.services.ProjectMasterService;
import com.metacube.training.services.SkillsMasterService;

/**
 * The class defines maping and handler methods for all employee urls
 * 
 * @author Shubham Jain
 *
 */
@Controller
@RequestMapping(value = "/employee")
public class EmployeeController {
    @Autowired
    ProjectMasterService projectMasterService;

    @Autowired
    SkillsMasterService skillsMasterService;

    @Autowired
    EmployeeService employeeService;

    @Autowired
    JobTitleService jobTitleService;

    @GetMapping("")
    public String employeeLogin() {
        return "employee/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String goToLogin() {
        return "employee/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String employeeLoginDetails(Model model,
            @RequestParam("email") String email,
            @RequestParam("password") String password) {
        Status status = employeeService.checkValidCredentials(email, password);
        if (Status.FOUND.equals(status)) {
            model.addAttribute("email", email);
            return "employee/dashboard";
        } else {
            return "redirect:login";
        }
    }

    @RequestMapping(value = "/editProfile", method = RequestMethod.POST)
    public String editProfile(Model model, @RequestParam("email") String email) {
        model.addAttribute("employee",
                employeeService.getEmployeeByEmail(email));
        return "employee/editProfile";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String Logout() {
        return "redirect:login";
    }

    @RequestMapping(value = "/updateProfile", method = RequestMethod.POST)
    public String updateProfile(@ModelAttribute("employee") Employee empolyee,
            Model model) {
        employeeService.update(empolyee);
        model.addAttribute("email", empolyee.getEmail());
        return "employee/dashboard";
    }

    @RequestMapping(value = "/searchEmployee", method = RequestMethod.GET)
    public String goToSearchEmployee() {
        return "employee/searchEmployee";
    }

    @RequestMapping(path = "/search", method = RequestMethod.GET)
    public String searchEmployee(Model model,
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName) {

        model.addAttribute("employees",
                employeeService.getEmployeeByName(firstName, lastName));
        return "employee/searchEmployee";
    }
}
