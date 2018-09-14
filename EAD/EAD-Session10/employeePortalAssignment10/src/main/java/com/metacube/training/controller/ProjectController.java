package com.metacube.training.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.metacube.training.model.ProjectMaster;
import com.metacube.training.services.ProjectMasterService;

@Controller
@RequestMapping(value = "/admin")
public class ProjectController {
    @Autowired
    ProjectMasterService projectMasterService;

    @RequestMapping(value = "/addProject", method = RequestMethod.GET)
    public String adminAddProject(Model model) {
        model.addAttribute("projectMaster", new ProjectMaster());
        return "admin/addProject";
    }

    @RequestMapping(value = "/addProject", method = RequestMethod.POST)
    public String adminAddProject(@Valid ProjectMaster projectMaster,BindingResult 
            bindingResult) {
        if(bindingResult.hasErrors()) {
            return "admin/addProject";
        }
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
}
