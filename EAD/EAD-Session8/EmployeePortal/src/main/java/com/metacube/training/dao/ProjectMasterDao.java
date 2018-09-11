package com.metacube.training.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.Query.Queries;
import com.metacube.training.Status.Status;
import com.metacube.training.models.ProjectMaster;

@Service
public class ProjectMasterDao implements BaseDao<ProjectMaster> {
    @Autowired
    Queries query;

    @Override
    public ProjectMaster getById(int id) {
        // TODO Auto-generated method stub
        ProjectMaster projectMaster = null;
        try (Connection connection = ConnectionManager.getConnection();
                PreparedStatement statement = connection.prepareStatement(query
                        .getGetProjectById());) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                projectMaster = new ProjectMaster();
                projectMaster.setProjectId(resultSet.getInt("project_id"));
                projectMaster
                        .setDescription(resultSet.getString("description"));
                projectMaster.setStartDate(resultSet.getDate("start_date"));
                projectMaster.setEndDate(resultSet.getDate("end_date"));
                projectMaster.setProjectLogo(resultSet
                        .getString("project_logo"));

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return projectMaster;
    }

    @Override
    public List<ProjectMaster> getAll() {
        // TODO Auto-generated method stub
        List<ProjectMaster> list = new ArrayList<ProjectMaster>();
        try (Connection connection = ConnectionManager.getConnection();
                PreparedStatement statement = connection.prepareStatement(query
                        .getGetAllProjects());) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ProjectMaster projectMaster = new ProjectMaster();
                projectMaster.setProjectId(resultSet.getInt("project_id"));
                projectMaster
                        .setDescription(resultSet.getString("description"));
                projectMaster.setStartDate(resultSet.getDate("start_date"));
                projectMaster.setEndDate(resultSet.getDate("end_date"));
                projectMaster.setProjectLogo(resultSet
                        .getString("project_logo"));
                list.add(projectMaster);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return list;
    }

    @Override
    public Status create(ProjectMaster projectMaster) {
        // TODO Auto-generated method stub
        try (Connection connection = ConnectionManager.getConnection();
                PreparedStatement statement = connection.prepareStatement(query
                        .getADD_PROJECT());) {
            statement.setString(1, projectMaster.getDescription());
            statement.setDate(2, projectMaster.getStartDate());
            statement.setDate(3, projectMaster.getEndDate());
            if (statement.executeUpdate() == 1) {
                return Status.INSERTED;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return Status.NOT_INSERTED;
    }

    @Override
    public Status update(ProjectMaster projectMaster) {
        // TODO Auto-generated method stub
        try (Connection connection = ConnectionManager.getConnection();
                PreparedStatement statement = connection.prepareStatement(query
                        .getUpdateProject());) {
            statement.setString(1, projectMaster.getDescription());
            statement.setDate(2, projectMaster.getStartDate());
            statement.setDate(3, projectMaster.getEndDate());
            statement.setInt(4, projectMaster.getProjectId());
            if (statement.executeUpdate() == 1) {
                return Status.UPDATED;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return Status.NOT_UPDATED;
    }

    @Override
    public Status delete(int id) {
        // TODO Auto-generated method stub
        try (Connection connection = ConnectionManager.getConnection();
                PreparedStatement statement = connection.prepareStatement(query
                        .getDeleteProject());) {
            statement.setInt(1, id);
            if (statement.executeUpdate() == 1) {
                return Status.DELETED;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return Status.NOT_UPDATED;
    }
}
