package com.metacube.training.dao;

import java.util.List;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.metacube.training.Query.Queries;
import com.metacube.training.Status.Status;
import com.metacube.training.mappers.projectMapper;
import com.metacube.training.model.ProjectMaster;

@Service
public class ProjectMasterDao implements BaseDao<ProjectMaster> {
    @Autowired
    private Queries query;

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void EmployeeDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public ProjectMaster getById(int id) {
        return jdbcTemplate.queryForObject(query.getProjectById(),
                new Object[] { id }, new projectMapper());
    }

    @Override
    public List<ProjectMaster> getAll() {
        return jdbcTemplate.query(query.getAllProjects(), new projectMapper());

    }

    @Override
    public Status create(ProjectMaster projectMaster) {
        int result = jdbcTemplate.update(query.getAddProject(),
                projectMaster.getDescription(), projectMaster.getStartDate(),
                projectMaster.getEndDate());
        if (result > 0) {
            return Status.INSERTED;
        }
        return Status.NOT_INSERTED;
    }

    @Override
    public Status update(ProjectMaster projectMaster) {
        int result = jdbcTemplate.update(query.getUpdateProject(),
                projectMaster.getDescription(), projectMaster.getStartDate(),
                projectMaster.getEndDate(), projectMaster.getProjectId());
        if (result > 0) {
            return Status.UPDATED;
        }
        return Status.NOT_UPDATED;
    }

    @Override
    public Status delete(int id) {
        int result = jdbcTemplate.update(query.getDeleteProject(), id);
        if (result > 0) {
            return Status.DELETED;
        }
        return Status.NOT_DELETED;
    }
}
