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
import com.metacube.training.models.Employee;
import com.metacube.training.models.JobTitle;
import com.metacube.training.models.ProjectMaster;

/**
 * The class implements basedao interface methods
 * 
 * @author Shubham Jain
 *
 */
@Service
public class EmployeeDao implements BaseDao<Employee> {
    @Autowired
    Queries query;

    @Override
    public Employee getById(int id) {
        // TODO Auto-generated method stub
        Employee employee = null;
        try (Connection connection = ConnectionManager.getConnection();
                PreparedStatement statement = connection.prepareStatement(query
                        .getGetEmployeById());) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                employee = new Employee();
                employee.setEmpCode(resultSet.getInt("emp_code"));
                employee.setFirstName(resultSet.getString("first_name"));
                employee.setMiddleName(resultSet.getString("middle_name"));
                employee.setLastName(resultSet.getString("last_name"));
                employee.setDob(resultSet.getDate("dob"));
                employee.setGender(resultSet.getString("gender"));
                employee.setEmail(resultSet.getString("email"));
                employee.setPrimaryContact(resultSet
                        .getString("primary_contact"));
                employee.setSecondaryContact(resultSet
                        .getString("secondary_contact"));
                employee.setSkypeId(resultSet.getString("skype_id"));
                employee.setPassword(resultSet.getString("password"));
                employee.setProfilePicture(resultSet
                        .getString("profile_picture"));
                return employee;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return employee;
    }

    @Override
    public List<Employee> getAll() {
        // TODO Auto-generated method stub
        List<Employee> list = new ArrayList<Employee>();
        try (Connection connection = ConnectionManager.getConnection();
                PreparedStatement statement = connection.prepareStatement(query
                        .getGetAllEmployes());) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Employee employee = new Employee();
                employee.setEmpCode(resultSet.getInt("emp_code"));
                employee.setFirstName(resultSet.getString("first_name"));
                employee.setMiddleName(resultSet.getString("middle_name"));
                employee.setLastName(resultSet.getString("last_name"));
                employee.setDob(resultSet.getDate("dob"));
                employee.setGender(resultSet.getString("gender"));
                employee.setEmail(resultSet.getString("email"));
                employee.setPrimaryContact(resultSet
                        .getString("primary_contact"));
                employee.setSecondaryContact(resultSet
                        .getString("secondary_contact"));
                employee.setSkypeId(resultSet.getString("skype_id"));
                employee.setPassword(resultSet.getString("password"));
                employee.setProfilePicture(resultSet
                        .getString("profile_picture"));
                list.add(employee);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    @Override
    public Status create(Employee employee) {
        // TODO Auto-generated method stub
        try (Connection connection = ConnectionManager.getConnection();
                PreparedStatement statement = connection.prepareStatement(query
                        .getADD_EMPLOYEE());) {

            statement.setString(1, employee.getFirstName());
            statement.setString(2, employee.getMiddleName());
            statement.setString(3, employee.getLastName());
            statement.setDate(4, employee.getDob());
            statement.setString(5, employee.getGender());
            statement.setString(6, employee.getEmail());
            statement.setString(7, employee.getPrimaryContact());
            statement.setString(8, employee.getSecondaryContact());
            statement.setString(9, employee.getSkypeId());
            int result = statement.executeUpdate();
            if (result > 0) {
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
    public Status update(Employee employee) {
        try (Connection connection = ConnectionManager.getConnection();
                PreparedStatement statement = connection.prepareStatement(query
                        .getUpdateEmployee());) {

            statement.setString(1, employee.getFirstName());
            statement.setString(2, employee.getMiddleName());
            statement.setString(3, employee.getLastName());
            statement.setDate(4, employee.getDob());
            statement.setString(5, employee.getGender());
            statement.setString(6, employee.getEmail());
            statement.setString(7, employee.getPrimaryContact());
            statement.setString(8, employee.getSecondaryContact());
            statement.setString(9, employee.getSkypeId());
            statement.setInt(10, employee.getEmpCode());
            int result = statement.executeUpdate();
            if (result > 0) {
                return Status.INSERTED;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return Status.NOT_INSERTED;
        // TODO Auto-generated method stub

    }

    @Override
    public Status delete(int id) {
        try (Connection connection = ConnectionManager.getConnection();
                PreparedStatement statement = connection.prepareStatement(query
                        .getDeleteEmployee());) {
            statement.setInt(1, id);
            int result = statement.executeUpdate();
            if (result > 0) {
                return Status.INSERTED;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        // TODO Auto-generated method stub
        return Status.NOT_DELETED;
    }

    public List<Employee> getEmployeeByName(String firstName, String lastName) {
        // TODO Auto-generated method stub
        List<Employee> list = new ArrayList<Employee>();
        try (Connection connection = ConnectionManager.getConnection();
                PreparedStatement statement = connection.prepareStatement(query
                        .getGetEmployeeByName());) {
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Employee employee = new Employee();
                employee.setEmpCode(resultSet.getInt("emp_code"));
                employee.setFirstName(resultSet.getString("first_name"));
                employee.setMiddleName(resultSet.getString("middle_name"));
                employee.setLastName(resultSet.getString("last_name"));
                employee.setDob(resultSet.getDate("dob"));
                employee.setGender(resultSet.getString("gender"));
                employee.setEmail(resultSet.getString("email"));
                employee.setPrimaryContact(resultSet
                        .getString("primary_contact"));
                employee.setSecondaryContact(resultSet
                        .getString("secondary_contact"));
                employee.setSkypeId(resultSet.getString("skype_id"));
                employee.setPassword(resultSet.getString("password"));
                employee.setProfilePicture(resultSet
                        .getString("profile_picture"));
                list.add(employee);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public Status checkValidCredentioals(String email, String password) {
        // TODO Auto-generated method stub
        List<Employee> list = new ArrayList<Employee>();
        try (Connection connection = ConnectionManager.getConnection();
                PreparedStatement statement = connection.prepareStatement(query
                        .getGetEmployeByemailandPass());) {
            statement.setString(1, email);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return Status.FOUND;
            }
            return Status.NOT_FOUND;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return Status.NOT_FOUND;
    }

    public Employee getEmployeeByEmail(String email) {
        // TODO Auto-generated method stub
        Employee employee = null;
        try (Connection connection = ConnectionManager.getConnection();
                PreparedStatement statement = connection.prepareStatement(query
                        .getGetEmployeeByEmail());) {
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                employee = new Employee();
                employee.setEmpCode(resultSet.getInt("emp_code"));
                employee.setFirstName(resultSet.getString("first_name"));
                employee.setMiddleName(resultSet.getString("middle_name"));
                employee.setLastName(resultSet.getString("last_name"));
                employee.setDob(resultSet.getDate("dob"));
                employee.setGender(resultSet.getString("gender"));
                employee.setEmail(resultSet.getString("email"));
                employee.setPrimaryContact(resultSet
                        .getString("primary_contact"));
                employee.setSecondaryContact(resultSet
                        .getString("secondary_contact"));
                employee.setSkypeId(resultSet.getString("skype_id"));
                employee.setPassword(resultSet.getString("password"));
                employee.setProfilePicture(resultSet
                        .getString("profile_picture"));
                return employee;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return employee;
    }
}
