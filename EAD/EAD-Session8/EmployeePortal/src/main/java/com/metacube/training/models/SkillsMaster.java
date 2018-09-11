package com.metacube.training.models;
/**
 * The class defines structure of skill master
 * @author Shubham Jain
 *
 */
public class SkillsMaster {
	private int skillId;
	private String skillName;
	private int active;
	
	public int getSkillId() {
		return skillId;
	}
	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}
	public String getSkillName() {
		return skillName;
	}
	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
}
