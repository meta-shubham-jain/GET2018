package com.metacube.training.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.training.models.JobTitle;

public class jobMapper implements RowMapper<JobTitle> {

    @Override
    public JobTitle mapRow(ResultSet resultSet, int arg1) throws SQLException {
        JobTitle jobTitle = new JobTitle();
        jobTitle.setJobCode(resultSet.getInt("job_code"));
        jobTitle.setJobTitle(resultSet.getString("job_title"));
        return jobTitle;
    }
}
