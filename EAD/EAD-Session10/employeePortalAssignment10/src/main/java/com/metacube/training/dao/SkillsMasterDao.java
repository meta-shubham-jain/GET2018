package com.metacube.training.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.metacube.training.Query.Queries;
import com.metacube.training.Status.Status;
import com.metacube.training.mappers.skillMapper;
import com.metacube.training.model.SkillsMaster;

/**
 * The class implements bas dao
 * 
 * @author Shubham Jain
 *
 */
@Service
public class SkillsMasterDao implements BaseDao<SkillsMaster> {
    @Autowired
    private Queries query;

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void EmployeeDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public SkillsMaster getById(int id) {
        return jdbcTemplate.queryForObject(query.getSkillById(),
                new Object[] { id }, new skillMapper());
    }

    @Override
    public List<SkillsMaster> getAll() {
        return jdbcTemplate.query(query.getAllSkills(), new skillMapper());
    }

    @Override
    public Status create(SkillsMaster skillMaster) {
        int result = jdbcTemplate.update(query.getAddSkills(),
                skillMaster.getSkillName());
        if (result > 0) {
            return Status.INSERTED;
        }
        return Status.NOT_INSERTED;
    }

    @Override
    public Status update(SkillsMaster skillMaster) {
        int result = jdbcTemplate.update(query.getUpdateSkills(),
                skillMaster.getSkillName(), skillMaster.getSkillId());
        if (result > 0) {
            return Status.UPDATED;
        }
        return Status.NOT_UPDATED;
    }

    @Override
    public Status delete(int id) {
        int result = jdbcTemplate.update(query.getDeleteSkills(), id);
        if (result > 0) {
            return Status.DELETED;
        }
        return Status.NOT_DELETED;
    }
}
