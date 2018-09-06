package com.metacube.advertisementwebservices.dao;

import com.metacube.advertisementwebservices.model.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Class for performing insertion , deletion and updation operations on category
 * table
 */
public class CategoryDao {

    private static CategoryDao mysqlCategoryDao = new CategoryDao();

    /**
     * Function to create singleton object
     * 
     * @return
     */
    public static CategoryDao getInstance() {
        return mysqlCategoryDao;
    }

    /**
     * Function to select all the categories
     * 
     * @return list of categories
     */
    public List<Category> getAll() {
        List<Category> categoryList = new ArrayList<Category>();
        String query = Query.getSelectAllCategories();
        ResultSet resultSet = null;
        try (Connection conn = ConnectionManager.getConnection();
                PreparedStatement preparedStatement = conn
                        .prepareStatement(query);) {
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Category category = new Category();
                category.setId(resultSet.getInt("category_id"));
                category.setName(resultSet.getString("name"));
                categoryList.add(category);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categoryList;
    }

    /**
     * Function to insert the data in the category table
     * 
     * @param name
     */
    public Status insert(String name) {
        String query = Query.getInsertNewCategory();
        try (Connection conn = ConnectionManager.getConnection();
                PreparedStatement preparedStatement = conn
                        .prepareStatement(query);) {
            preparedStatement.setString(1, name);
            if (preparedStatement.executeUpdate() == 0) {
                return Status.NOT_INSERTED;
            }
        } catch (SQLException | AssertionError e) {
            e.printStackTrace();
        }
        return Status.INSERTED;
    }

    /**
     * Function to update the name of the category
     * 
     * @param name
     * @param id
     */
    public Status updateCategory(String category, int id) {
        String query = Query.getUpdateCategoryName();
        try (Connection conn = ConnectionManager.getConnection();
                PreparedStatement preparedStatement = conn
                        .prepareStatement(query);) {
            preparedStatement.setString(1, category);
            preparedStatement.setInt(2, id);
            if (preparedStatement.executeUpdate() == 0) {
                return Status.NOT_UPDATED;
            }
        } catch (SQLException | AssertionError e) {
            e.printStackTrace();
        }
        return Status.UPDATED;
    }
}
