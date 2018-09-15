package com.metacube.training.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.Status.Status;
import com.metacube.training.dao.SkillsMasterDao;
import com.metacube.training.dao.SkillsMasterDaoInterface;
import com.metacube.training.models.SkillsMaster;
/**
 * The class implements baseservice  and implements method
 * @author Shubham Jain
 *
 */
@Service
public class SkillsMasterService implements BaseService<SkillsMaster>{
	
    @Autowired
	SkillsMasterDaoInterface skillsMasterDao;
	
	@Override
	public SkillsMaster getById(int id) {
		// TODO Auto-generated method stub
		return skillsMasterDao.getById(id);
	}

	@Override
	public List<SkillsMaster> getAll() {
		// TODO Auto-generated method stub
		return skillsMasterDao.getAll();
	}

	@Override
	public Status create(SkillsMaster entity) {
		// TODO Auto-generated method stub
		return skillsMasterDao.create(entity);
	}

	@Override
	public Status update(SkillsMaster entity) {
		// TODO Auto-generated method stub
		return skillsMasterDao.update(entity);
	}

	public Status delete(SkillsMaster skills) {
		// TODO Auto-generated method stub
		return skillsMasterDao.delete(skills);
	}

    @Override
    public Status delete(int id) {
        // TODO Auto-generated method stub
        return null;
    }
}
