package com.metacube.training.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.metacube.training.Status.Status;
import com.metacube.training.models.SkillsMaster;
import com.metacube.training.repository.SkillsMasterRepository;

/**
 * The class implements baseservice and implements method
 * 
 * @author Shubham Jain
 *
 */
@Service
public class SkillsMasterService implements BaseService<SkillsMaster> {

	@Autowired
	SkillsMasterRepository skillsMasterRepository;

	/**
	 * Get skills by id
	 * 
	 * @param id
	 * @return
	 */
	@Override
	public SkillsMaster getById(int id) {
		return skillsMasterRepository.findOne(id);
	}

	/**
	 * Get list of all skills
	 * 
	 * @return
	 */
	@Override
	public List<SkillsMaster> getAll() {
		return skillsMasterRepository.findByActive(true);
	}

	/**
	 * Create skills
	 * 
	 * @param skill
	 * @return
	 */
	@Override
	public Status create(SkillsMaster skill) {
		skillsMasterRepository.save(skill);
		return null;
	}

	/**
	 * Update skills
	 * 
	 * @param skill
	 * @return
	 */
	@Override
	public Status update(SkillsMaster skill) {
		skillsMasterRepository.save(skill);
		return null;
	}

	/**
	 * Delete skills
	 * 
	 * @param id
	 * @return
	 */
	@Override
	public Status delete(int id) {
		skillsMasterRepository.setInActiveById(false, id);
		return Status.DELETED;
	}
}