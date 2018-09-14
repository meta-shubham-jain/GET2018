package com.metacube.training.model;

import java.sql.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * THe class defines structure of employee
 * 
 * @author Shubham Jain
 *
 */
public class Employee {
    private int empCode;
    @NotBlank(message = "Enter first Name")
    @Pattern(regexp = "^([a-zA-Z]{2,})$", message = "Invalid first name")
    private String firstName;
    @NotBlank(message = "Enter middle name")
    @Pattern(regexp = "^([a-zA-Z]{2,})$", message = "Invalid middle name")
    private String middleName;
    @NotBlank(message = "Enter last name")
    @Pattern(regexp = "^([a-zA-Z]{2,})$", message = "Invalid last name")
    private String lastName;
    @NotNull(message = "Enter dob")
    private Date dob;
    @NotBlank(message = "Enter gender")
    private String gender;
    @NotBlank(message = "Enter email")
    @Pattern(regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", message = "Email address is invalid")
    private String email;
    @NotBlank(message = "Enter primary contact")
    @Pattern(regexp = "^([0-9]+)$", message = "Enter valid contact")
    @Size(min = 8, max = 11, message = "contact invalid")
    private String primaryContact;
    private String secondaryContact;
    @NotBlank(message = "Enter skype email")
    @Pattern(regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", message = "Email address is invalid")
    private String skypeId;
    private String profilePicture;
    private String password;
    private String[] skills;
    private int enabled;
    private int active;

    public int getEmpCode() {
        return empCode;
    }

    public void setEmpCode(int empCode) {
        this.empCode = empCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPrimaryContact() {
        return primaryContact;
    }

    public void setPrimaryContact(String primaryContact) {
        this.primaryContact = primaryContact;
    }

    public String getSecondaryContact() {
        return secondaryContact;
    }

    public void setSecondaryContact(String secondaryContact) {
        this.secondaryContact = secondaryContact;
    }

    public String getSkypeId() {
        return skypeId;
    }

    public void setSkypeId(String skypeId) {
        this.skypeId = skypeId;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String[] getSkills() {
        return skills;
    }

    public void setSkills(String[] skills) {
        this.skills = skills;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }
}
