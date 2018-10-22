package com.metacube.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.metacube.training.models.JobTitle;
import com.metacube.training.services.JobTitleService;

@Controller
@RequestMapping(value = "/admin")
public class JobController {

	@Autowired
	JobTitleService jobTitleService;

	/**
	 * Redirecting to add job page
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/addJob", method = RequestMethod.GET)
	public String adminJob(Model model) {
		model.addAttribute("jobTitle", new JobTitle());
		return "admin/addJob";
	}

	/**
	 * Receives request to add job
	 * 
	 * @param jobTitle
	 * @return
	 */
	@RequestMapping(value = "/addJob", method = RequestMethod.POST)
	public String adminAddJob(JobTitle jobTitle) {
		if (jobTitle != null && jobTitle.getJobCode() == 0) {
			jobTitleService.create(jobTitle);
		} else {
			jobTitleService.update(jobTitle);
		}
		return "redirect:dashboard";
	}

	/**
	 * Receives request to show all jobs
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(path = "/allJobs", method = RequestMethod.GET)
	public String getAllJobs(Model model) {
		model.addAttribute("jobs", jobTitleService.getAll());
		return "admin/allJobs";
	}

	/**
	 * Redirecting to edit job page
	 * 
	 * @param model
	 * @param jobCode
	 * @return
	 */
	@RequestMapping(path = "/editJob", method = RequestMethod.GET)
	public String editJob(Model model, @RequestParam("id") int jobCode) {
		model.addAttribute("jobTitle", jobTitleService.getById(jobCode));
		return "admin/addJob";
	}

	/**
	 * Recieves request to delete job
	 * 
	 * @param model
	 * @param jobCode
	 * @return
	 */
	@RequestMapping(path = "/deleteJob", method = RequestMethod.GET)
	public String deleteJob(Model model, @RequestParam("id") int jobCode) {
		jobTitleService.delete(jobCode);
		return "redirect:allJobs";
	}
}