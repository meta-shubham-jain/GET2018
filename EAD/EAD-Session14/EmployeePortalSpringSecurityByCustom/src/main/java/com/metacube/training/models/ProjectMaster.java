package com.metacube.training.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The class defines the structure of project master
 * 
 * @author Shubham Jain
 *
 */

@Entity
@Table(name = "project_master")
public class ProjectMaster {

    @Id
    @Column(name="project_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int projectId;
    @Column(name = "description")
    private String description;
    @Column(name = "start_date")
    private Date startDate;
    @Column(name = "end_date")
    private Date endDate; 
    @Column(name = "active", columnDefinition = "BIT")
    private boolean active = true;

    public int getProjectId() {
        return projectId;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
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
}
