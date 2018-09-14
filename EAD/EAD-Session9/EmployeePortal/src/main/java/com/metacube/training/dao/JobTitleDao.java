package com.metacube.training.dao;

import java.util.List;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.metacube.training.Query.Queries;
import com.metacube.training.Status.Status;
import com.metacube.training.mappers.jobMapper;
import com.metacube.training.models.JobTitle;

/**
 * The class implements method basedao and implements it
 * 
 * @author Shubham Jain
 *
 */
@Service
public class JobTitleDao implements BaseDao<JobTitle> {
    @Autowired
    Queries query;

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void EmployeeDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public JobTitle getById(int id) {
        return jdbcTemplate.queryForObject(query.getJobtileByCode(),
                new Object[] { id }, new jobMapper());
    }

    @Override
    public List<JobTitle> getAll() {
        return jdbcTemplate.query(query.getAllJobTitle(), new jobMapper());
    }

    @Override
    public Status create(JobTitle entity) {
        int result = jdbcTemplate.update(query.getAddJobTitle(),
                entity.getJobTitle());
        if (result > 0) {
            return Status.INSERTED;
        }
        return Status.NOT_INSERTED;
    }

    @Override
    public Status update(JobTitle entity) {
        int result = jdbcTemplate.update(query.getUpdateJobTitle(),
                entity.getJobTitle(), entity.getJobCode());
        if (result > 0) {
            return Status.UPDATED;
        }
        return Status.NOT_UPDATED;
    }

    @Override
    public Status delete(int id) {
        int result = jdbcTemplate.update(query.getDeleteJobTitle(), id);
        if (result > 0) {
            return Status.DELETED;
        }
        return Status.NOT_DELETED;
    }
}