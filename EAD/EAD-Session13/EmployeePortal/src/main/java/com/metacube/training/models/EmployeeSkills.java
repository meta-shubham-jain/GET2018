package com.metacube.training.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee_skills")
public class EmployeeSkills {

    @Id
    @Column(name = "emp_skill_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int empSkillId;

    @Column(name = "emp_code")
    private int empCode;

    @Column(name = "skill_code")
    private int skillCode;

    public int getEmpSkillId() {
        return empSkillId;
    }

    public void setEmpSkillId(int empSkillId) {
        this.empSkillId = empSkillId;
    }

    public int getEmpCode() {
        return empCode;
    }

    public void setEmpCode(int empCode) {
        this.empCode = empCode;
    }

    public int getSkillCode() {
        return skillCode;
    }

    public void setSkillCode(int skillCode) {
        this.skillCode = skillCode;
    }

}
