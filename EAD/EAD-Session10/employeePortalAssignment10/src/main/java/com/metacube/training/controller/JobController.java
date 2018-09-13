package com.metacube.training.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.metacube.training.model.JobTitle;
import com.metacube.training.services.JobTitleService;

@Controller
@RequestMapping(value = "/admin")
public class JobController {

    @Autowired
    JobTitleService jobTitleService;

    @RequestMapping(value = "/addJob", method = RequestMethod.GET)
    public String adminJob(Model model) {
        model.addAttribute("jobTitle", new JobTitle());
        return "admin/addJob";
    }

    @RequestMapping(value = "/addJob", method = RequestMethod.POST)
    public String adminAddJob(@Valid JobTitle jobTitle,BindingResult 
            bindingResult) {
        if(bindingResult.hasErrors()) {
            return "admin/addJob";
        }
        if (jobTitle != null && jobTitle.getJobCode() == 0) {
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
}