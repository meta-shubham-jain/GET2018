package com.metacube.training.model;

import java.sql.Date;

import javax.validation.constraints.NotBlank;

/**
 * The class defines the structure of project master
 * 
 * @author Shubham Jain
 *
 */
public class ProjectMaster {
    private int projectId;
    @NotBlank(message = "Enter Description")
    private String description;
    private Date startDate;
    private Date endDate;
    private String projectLogo;

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getProjectLogo() {
        return projectLogo;
    }

    public void setProjectLogo(String projectLogo) {
        this.projectLogo = projectLogo;
    }
}
