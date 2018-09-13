package com.metacube.training.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.metacube.training.Status.Status;
import com.metacube.training.model.Employee;
import com.metacube.training.services.EmailService;
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

    @Autowired
    EmailService emailService;

    private HttpSession session = null;

    /**
     * Redirecting to employee login page
     * 
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String goToLogin() {
        return "employee/login";
    }

    /**
     * It will receive request to validate employee login credentials
     * 
     * @param email
     * @param password
     * @param request
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String employeeLoginDetails(@RequestParam("email") String email,
            @RequestParam("password") String password,
            HttpServletRequest request) {
        Status status = employeeService.checkValidCredentials(email, password);
        if (Status.OK.equals(status)) {
            session = request.getSession();
            session.setAttribute("email", email);
            return "employee/dashboard";
        } else {
            return "redirect:login";
        }
    }

    /**
     * Redirecting to edit profile page
     * 
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "/editProfile", method = RequestMethod.GET)
    public String editProfile(Model model, HttpServletRequest request) {
        if (request.getSession(false) != null) {
            String email = (String) session.getAttribute("email");
            model.addAttribute("employee",
                    employeeService.getEmployeeByEmail(email));
            return "employee/editProfile";
        }
        return "redirect:login";
    }

    /**
     * It will get request to update profile details
     * 
     * @param empolyee
     * @param bindingResult
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "/updateProfile", method = RequestMethod.POST)
    public String updateProfile(
            @Valid @ModelAttribute("employee") Employee empolyee,
            BindingResult bindingResult, Model model, HttpServletRequest request) {
        if (request.getSession(false) != null) {
            if (bindingResult.hasErrors()) {
                return "employee/editProfile";
            }
            employeeService.update(empolyee);
            model.addAttribute("email", empolyee.getEmail());
            return "employee/dashboard";
        }
        return "redirect:login";
    }

    /**
     * It will redirect to search employee page
     * 
     * @param request
     * @return
     */
    @RequestMapping(value = "/searchEmployee", method = RequestMethod.GET)
    public String goToSearchEmployee(HttpServletRequest request) {
        if (request.getSession(false) != null) {
            return "employee/searchEmployee";
        }
        return "redirect:login";
    }

    /**
     * It will search employee
     * 
     * @param model
     * @param firstName
     * @param lastName
     * @param request
     * @return
     */
    @RequestMapping(path = "/search", method = RequestMethod.GET)
    public String searchEmployee(Model model,
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName,
            HttpServletRequest request) {
        if (request.getSession(false) != null) {
            model.addAttribute("employees",
                    employeeService.getEmployeeByName(firstName, lastName));
            return "employee/searchEmployee";
        }
        return "redirect:login";
    }

    /**
     * It will get request to logout
     * 
     * @param request
     * @return
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request) {
        session = request.getSession(false);
        session.invalidate();
        return "redirect:login";
    }

    /**
     * Redirecting to login page
     * 
     * @param request
     * @return
     */
    @RequestMapping(path = "/home", method = RequestMethod.GET)
    public String goToHome(HttpServletRequest request) {
        if (request.getSession(false) != null) {
            return "employee/dashboard";
        }
        return "redirect:login";
    }

    /**
     * Redirecting to forget password page
     * 
     * @return
     */
    @RequestMapping(value = "/forgetPassword", method = RequestMethod.GET)
    public String forgetPassword() {
        return "employee/forgetPassword";
    }

    /**
     * Receive forget password details
     * 
     * @param email
     * @param model
     * @return
     */
    @RequestMapping(value = "/forgetPassword", method = RequestMethod.POST)
    public String forgetPasswordEmailVerify(
            @RequestParam("email") String email, Model model) {
        Employee employee = employeeService.getEmployeeByEmail(email);
        if (employee == null) {
            model.addAttribute("error", "Email Id doesn't exists");
            return "employee/forgetPassword";
        } else {
            emailService.sendEmail(employee);
        }
        return "redirect:login";
    }
}