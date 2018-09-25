package com.metacube.training.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

	@Autowired
	private HttpSession session = null;

	/**
	 * Redirecting to edit profile
	 * 
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/editProfile", method = RequestMethod.GET)
	public String editProfile(Model model, HttpServletRequest request) {
		if (request.getSession(false) != null) {
			String email = (String) session.getAttribute("email");
			model.addAttribute("employee", employeeService.getEmployeeByEmail(email));
			return "employee/editProfile";
		}
		return "redirect:login";
	}

	/**
	 * Method for request of update profile
	 * 
	 * @param empolyee
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/updateProfile", method = RequestMethod.POST)
	public String updateProfile(@ModelAttribute("employee") Employee empolyee, Model model,
			HttpServletRequest request) {
		if (request.getSession(false) != null) {
			employeeService.update(empolyee);
			model.addAttribute("email", empolyee.getEmail());
			return "employee/dashboard";
		}
		return "redirect:login";
	}

	/**
	 * Redirecting to search employee page
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
	 * Search employee by first name and last name
	 * 
	 * @param model
	 * @param firstName
	 * @param lastName
	 * @param request
	 * @return
	 */
	@RequestMapping(path = "/search", method = RequestMethod.GET)
	public String searchEmployee(Model model, @RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName, HttpServletRequest request) {
		if (request.getSession(false) != null) {
			model.addAttribute("employees", employeeService.getEmployeeByName(firstName, lastName));
			return "employee/searchEmployee";
		}
		return "redirect:login";
	}

	/**
	 * Redirecting to home page
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
}