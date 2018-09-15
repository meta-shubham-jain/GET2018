package com.metacube.training.dao;

import java.util.List;

import com.metacube.training.Status.Status;
import com.metacube.training.models.SkillsMaster;

public interface SkillsMasterDaoInterface {
    
    public SkillsMaster getById(int id);

    public List<SkillsMaster> getAll();

    public Status create(SkillsMaster entity);

    public Status update(SkillsMaster entity);

    public Status delete(SkillsMaster entity);
}
