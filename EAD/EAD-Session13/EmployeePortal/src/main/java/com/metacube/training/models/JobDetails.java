package com.metacube.training.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * the class defines job details
 * 
 * @author Shubham Jain
 *
 */
@Entity
@Table(name = "job_details")
public class JobDetails {
	@Id
	@Column(name = "job_detail_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int jobDetailId;

	@Column(name = "emp_code")
	int empCode;

	@Column(name = "date_of_joining")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	Date dateOfJoining;

	@Column(name = "total_exp")
	int totalExp;

	@Column(name = "job_code")
	int jobCode;

	@Column(name = "reporting_manager")
	int reportingManager;

	@Column(name = "team_lead")
	int teamLead;

	@Column(name = "current_project_id")
	int projectId;

	@Column(name = "active", columnDefinition = "BIT")
	private boolean active = true;

	/**
	 * @return the jobDetailId
	 */
	public int getJobDetailId() {
		return jobDetailId;
	}

	/**
	 * @param jobDetailId the jobDetailId to set
	 */
	public void setJobDetailId(int jobDetailId) {
		this.jobDetailId = jobDetailId;
	}

	/**
	 * @return the empCode
	 */
	public int getEmpCode() {
		return empCode;
	}

	/**
	 * @param empCode the empCode to set
	 */
	public void setEmpCode(int empCode) {
		this.empCode = empCode;
	}

	/**
	 * @return the dateOfJoining
	 */
	public Date getDateOfJoining() {
		return dateOfJoining;
	}

	/**
	 * @param dateOfJoining the dateOfJoining to set
	 */
	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	/**
	 * @return the totalExp
	 */
	public int getTotalExp() {
		return totalExp;
	}

	/**
	 * @param totalExp the totalExp to set
	 */
	public void setTotalExp(int totalExp) {
		this.totalExp = totalExp;
	}

	/**
	 * @return the jobCode
	 */
	public int getJobCode() {
		return jobCode;
	}

	/**
	 * @param jobCode the jobCode to set
	 */
	public void setJobCode(int jobCode) {
		this.jobCode = jobCode;
	}

	/**
	 * @return the reportingManager
	 */
	public int getReportingManager() {
		return reportingManager;
	}

	/**
	 * @param reportingManager the reportingManager to set
	 */
	public void setReportingManager(int reportingManager) {
		this.reportingManager = reportingManager;
	}

	/**
	 * @return the teamLead
	 */
	public int getTeamLead() {
		return teamLead;
	}

	/**
	 * @param teamLead the teamLead to set
	 */
	public void setTeamLead(int teamLead) {
		this.teamLead = teamLead;
	}

	/**
	 * @return the projectId
	 */
	public int getProjectId() {
		return projectId;
	}

	/**
	 * @param projectId the projectId to set
	 */
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	/**
	 * @return the active
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * @param active the active to set
	 */
	public void setActive(boolean active) {
		this.active = active;
	}

}