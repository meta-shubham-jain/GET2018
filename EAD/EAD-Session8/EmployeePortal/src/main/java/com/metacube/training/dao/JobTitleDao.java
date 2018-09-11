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

    @Override
    public JobTitle getById(int id) {
        JobTitle jobTitle = null;
        try (Connection connection = ConnectionManager.getConnection();
                PreparedStatement statement = connection.prepareStatement(query
                        .getGetJobtileByCode());) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                jobTitle = new JobTitle();
                jobTitle.setJobCode(resultSet.getInt("job_code"));
                jobTitle.setJobTitle(resultSet.getString("job_title"));
                return jobTitle;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return jobTitle;
    }

    @Override
    public List<JobTitle> getAll() {
        List<JobTitle> list = new ArrayList<JobTitle>();
        try (Connection connection = ConnectionManager.getConnection();
                PreparedStatement statement = connection.prepareStatement(query
                        .getGetAllJobTitle());) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                JobTitle jobTitle = new JobTitle();
                jobTitle.setJobCode(resultSet.getInt("job_code"));
                jobTitle.setJobTitle(resultSet.getString("job_title"));
                list.add(jobTitle);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    @Override
    public Status create(JobTitle entity) {
        try (Connection connection = ConnectionManager.getConnection();
                PreparedStatement statement = connection.prepareStatement(query
                        .getAddJobTitle());) {
            statement.setInt(1, entity.getJobCode());
            statement.setString(2, entity.getJobTitle());
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
    public Status update(JobTitle entity) {
        try (Connection connection = ConnectionManager.getConnection();
                PreparedStatement statement = connection.prepareStatement(query
                        .getUpdateJobTitle());) {
            statement.setString(1, entity.getJobTitle());
            statement.setInt(2, entity.getJobCode());
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
        try (Connection connection = ConnectionManager.getConnection();
                PreparedStatement statement = connection.prepareStatement(query
                        .getDeleteJobTitle());) {
            statement.setInt(1, id);
            if (statement.executeUpdate() == 1) {
                return Status.DELETED;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return Status.NOT_DELETED;
    }
}
