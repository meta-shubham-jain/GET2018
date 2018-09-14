package com.metacube.training.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.metacube.training.models.ProjectMaster;

public class projectMapper implements RowMapper<ProjectMaster> {

    @Override
    public ProjectMaster mapRow(ResultSet resultSet, int arg1)
            throws SQLException {
        ProjectMaster projectMaster = new ProjectMaster();
        projectMaster.setProjectId(resultSet.getInt("project_id"));
        projectMaster.setDescription(resultSet.getString("description"));
        projectMaster.setStartDate(resultSet.getDate("start_date"));
        projectMaster.setEndDate(resultSet.getDate("end_date"));
        projectMaster.setProjectLogo(resultSet.getString("project_logo"));
        return projectMaster;
    }
}
