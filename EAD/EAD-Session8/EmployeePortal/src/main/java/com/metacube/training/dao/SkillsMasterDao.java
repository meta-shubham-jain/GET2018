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
import com.metacube.training.models.SkillsMaster;

/**
 * The class implements bas dao
 * 
 * @author Shubham Jain
 *
 */
@Service
public class SkillsMasterDao implements BaseDao<SkillsMaster> {
    @Autowired
    Queries query;

    @Override
    public SkillsMaster getById(int id) {
        SkillsMaster skillsMaster = null;
        try (Connection connection = ConnectionManager.getConnection();
                PreparedStatement statement = connection.prepareStatement(query
                        .getGetSkillById());) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                skillsMaster = new SkillsMaster();
                skillsMaster.setSkillId(resultSet.getInt("skill_id"));
                skillsMaster.setSkillName(resultSet.getString("skill_name"));
                return skillsMaster;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return skillsMaster;
    }

    @Override
    public List<SkillsMaster> getAll() {
        List<SkillsMaster> list = new ArrayList<SkillsMaster>();
        try (Connection connection = ConnectionManager.getConnection();
                PreparedStatement statement = connection.prepareStatement(query
                        .getGetAllSkills());) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                SkillsMaster skillsMaster = new SkillsMaster();
                skillsMaster.setSkillId(resultSet.getInt("skill_id"));
                skillsMaster.setSkillName(resultSet.getString("skill_name"));
                list.add(skillsMaster);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    @Override
    public Status create(SkillsMaster entity) {
        try (Connection connection = ConnectionManager.getConnection();
                PreparedStatement statement = connection.prepareStatement(query
                        .getAdd_Skills());) {
            statement.setString(1, entity.getSkillName());
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
    public Status update(SkillsMaster entity) {
        try (Connection connection = ConnectionManager.getConnection();
                PreparedStatement statement = connection.prepareStatement(query
                        .getUpdateSkills());) {
            statement.setString(1, entity.getSkillName());
            statement.setInt(2, entity.getSkillId());
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
                        .getDeletSkills());) {
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
