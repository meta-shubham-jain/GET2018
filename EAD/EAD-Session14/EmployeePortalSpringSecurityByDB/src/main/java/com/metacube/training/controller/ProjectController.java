package com.metacube.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.metacube.training.models.ProjectMaster;
import com.metacube.training.services.ProjectMasterService;

@Controller
@RequestMapping(value = "/admin")
public class ProjectController {

	@Autowired
	ProjectMasterService projectMasterService;

	/**
	 * Redirecting to add project page
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/addProject", method = RequestMethod.GET)
	public String adminAddProject(Model model) {
		model.addAttribute("projectMaster", new ProjectMaster());
		return "admin/addProject";
	}

	/**
	 * Receive request to add project
	 * 
	 * @param projectMaster
	 * @return
	 */
	@RequestMapping(value = "/addProject", method = RequestMethod.POST)
	public String adminAddProject(ProjectMaster projectMaster) {
		if (projectMaster != null && projectMaster.getProjectId() == 0) {
			projectMasterService.create(projectMaster);
		} else {
			projectMasterService.update(projectMaster);
		}
		return "redirect:dashboard";
	}

	/**
	 * Receive request to show all projects
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(path = "/allProjects", method = RequestMethod.GET)
	public String getAllProjects(Model model) {
		model.addAttribute("projects", projectMasterService.getAll());
		return "admin/allProjects";
	}

	/**
	 * Redirect to edit project page
	 * 
	 * @param model
	 * @param projectId
	 * @return
	 */
	@RequestMapping(path = "/editProject", method = RequestMethod.GET)
	public String editProject(Model model, @RequestParam("id") int projectId) {
		model.addAttribute("projectMaster", projectMasterService.getById(projectId));
		return "admin/addProject";
	}

	/**
	 * Receives request for delete project
	 * 
	 * @param model
	 * @param projectId
	 * @return
	 */
	@RequestMapping(path = "/deleteProject", method = RequestMethod.GET)
	public String deleteProject(Model model, @RequestParam("id") int projectId) {
		projectMasterService.delete(projectId);
		return "redirect:allProjects";
	}
}