package com.metacube.training.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.metacube.training.Status.Status;
import com.metacube.training.models.EmployeeSkills;
import com.metacube.training.repository.EmployeeSkillsRepository;

@Service
public class EmployeeSkillsService implements BaseService<EmployeeSkills> {

	@Autowired
	EmployeeSkillsRepository employeeSkillsRepository;

	/**
	 * Get employee skills by id
	 * 
	 * @param id
	 * @return
	 */
	@Override
	public EmployeeSkills getById(int id) {
		return employeeSkillsRepository.findOne(id);
	}

	/**
	 * Get list of skills
	 * 
	 * @return
	 */
	@Override
	public List<EmployeeSkills> getAll() {
		return employeeSkillsRepository.findAll();
	}

	/**
	 * Store skills of employee
	 * 
	 * @param skills
	 * @param empCode
	 * @return
	 */
	public Status create(String[] skills, int empCode) {
		for (String skillId : skills) {
			EmployeeSkills employeeSkills = new EmployeeSkills();
			employeeSkills.setEmpCode(empCode);
			employeeSkills.setSkillCode(Integer.parseInt(skillId));
			employeeSkillsRepository.save(employeeSkills);
		}
		return Status.INSERTED;
	}

	/**
	 * Update skills of employee
	 * 
	 * @param entity
	 * @return
	 */
	@Override
	public Status update(EmployeeSkills entity) {
		employeeSkillsRepository.save(entity);
		return Status.UPDATED;
	}

	/**
	 * delete skills
	 * 
	 * @param id
	 * @return
	 */
	@Override
	public Status delete(int id) {
		return null;
	}

	/**
	 * Create skills
	 * 
	 * @param entity
	 * @return
	 */
	@Override
	public Status create(EmployeeSkills entity) {
		return null;
	}
}