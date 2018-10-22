package com.metacube.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.metacube.training.models.EmployeeSkills;

public interface EmployeeSkillsRepository extends
        JpaRepository<EmployeeSkills, Integer> {

}
