package com.metacube.training.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Controller for Welcome
 * 
 * @author Shubham Jain
 *
 */
@Controller

public class WelcomeToWebsite {

	/**
	 * Request for Welcome Page
	 * 
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcome() {
		return "welcome";
	}

	/**
	 * Redirecting to login page
	 * 
	 * @param error
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(@RequestParam(value = "error", required = false) String error, Model model) {
		if (error == null) {
			return "login";
		}
		if (error.equals("true")) {
			model.addAttribute("error", "error");
		}
		return "login";
	}

	/**
	 * Redirecting to dashboard
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/default", method = RequestMethod.GET)
	public String afterLogin(HttpServletRequest request) {
		if (request.isUserInRole("ADMIN")) {
			return "redirect:/admin/dashboard";
		}
		return "redirect:/employee/dashboard";
	}
}