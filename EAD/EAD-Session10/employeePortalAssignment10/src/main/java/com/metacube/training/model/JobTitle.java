package com.metacube.training.model;

import javax.validation.constraints.NotBlank;

/**
 * The class defines the stucture of job title
 * 
 * @author Shubham Jain
 *
 */
public class JobTitle {

    private int jobCode;
    @NotBlank(message = "Enter Job Title")
    private String jobTitle;

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
     * @param jobTitle
     *            the jobTitle to set
     */
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }
}