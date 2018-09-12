package com.metacube.training.controller;

import javax.servlet.http.HttpSession;

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
import com.metacube.training.services.EmployeeService;
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
    private HttpSession session;

    @GetMapping("/login")
    public String adminLogin() {
        return "admin/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView adminLoginDetails(@RequestParam("email") String email,
            @RequestParam("password") String password) {
        if (!email.equals("admin") || !password.equals("admin")) {
            return new ModelAndView("admin/login", "error",
                    "Invalid Username and Password");
        }
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

    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public String gotoDashboard() {
        return "admin/dashboard";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout() {
        return "redirect:login";
    }
}