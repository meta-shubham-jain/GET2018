package com.metacube.training.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The class defines the stucture of job title
 * 
 * @author Shubham Jain
 *
 */
@Entity
@Table(name = "job_title")
public class JobTitle {
    @Id
    @Column(name = "job_code")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int jobCode;
    @Column(name = "job_title")
    private String jobTitle;
    @Column(name = "active", columnDefinition = "BIT")
    private boolean active = true;

    /**
     * @return the jobCode
     */
    public int getJobCode() {
        return jobCode;
    }

    /**
     * @param jobCode
     *            the jobCode to set
     */
    public void setJobCode(int jobCode) {
        this.jobCode = jobCode;
    }

    /**
     * @return the jobTitle
     */
    public String getJobTitle() {
        return jobTitle;
    }

    /**
     * @param jobTitle the jobTitle to set
     */
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}