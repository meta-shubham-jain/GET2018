package com.metacube.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.metacube.training.models.SkillsMaster;
import com.metacube.training.services.SkillsMasterService;

/**
 * Skill Controller
 * 
 * @author Shubham Jain
 *
 */
@Controller
@RequestMapping(value = "/admin")
public class SkillsController {

	@Autowired
	SkillsMasterService skillsMasterService;

	/**
	 * Redirect to add Skills Page
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/addSkills", method = RequestMethod.GET)
	public String adminAddSkills(Model model) {
		model.addAttribute("skillsMaster", new SkillsMaster());
		return "admin/addSkills";
	}

	/**
	 * Receives request of adding Skills
	 * 
	 * @param skillsMaster
	 * @return
	 */
	@RequestMapping(value = "/addSkills", method = RequestMethod.POST)
	public String adminAddSkills(SkillsMaster skillsMaster) {
		if (skillsMaster != null && skillsMaster.getSkillId() == 0) {
			skillsMasterService.create(skillsMaster);
		} else {
			skillsMasterService.update(skillsMaster);
		}
		return "redirect:dashboard";
	}

	/**
	 * Redirect to all skills page
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(path = "/allSkills", method = RequestMethod.GET)
	public String getAllSkills(Model model) {
		model.addAttribute("skills", skillsMasterService.getAll());
		return "admin/allSkills";
	}

	/**
	 * Redirect to Edit Skills Page
	 * 
	 * @param model
	 * @param skillId
	 * @return
	 */
	@RequestMapping(path = "/editSkills", method = RequestMethod.GET)
	public String editSkill(Model model, @RequestParam("id") int skillId) {
		model.addAttribute("skillsMaster", skillsMasterService.getById(skillId));
		return "admin/addSkills";
	}

	/**
	 * Receive requests for delete skill
	 * 
	 * @param model
	 * @param skillId
	 * @return
	 */
	@RequestMapping(path = "/deleteSkill", method = RequestMethod.GET)
	public String deleteSkill(Model model, @RequestParam("id") int skillId) {
		skillsMasterService.delete(skillId);
		return "redirect:allSkills";
	}
}