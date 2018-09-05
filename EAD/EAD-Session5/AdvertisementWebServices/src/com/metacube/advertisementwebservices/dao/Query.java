package com.metacube.advertisementwebservices.dao;

public class Query {
    private static final String insertNewCategory = "INSERT INTO category(name) VALUES(?)";
    private static final String selectAllCategories = "SELECT * FROM category";
    private static final String insertNewAdvertisement = "INSERT INTO advertisement (title, description , category_id) "
            + "VALUES (?,?,?)";
    private static final String selectAllAdvertisement = "SELECT * FROM advertisement";
    private static final String selectAllAdvertisementByCategoryId = "SELECT * FROM advertisement WHERE category_id=?";
    private static final String updateAdvertisementName = "UPDATE advertisement SET title = ? WHERE advertisement_id=?";
    private static final String updateCategoryName = "UPDATE category SET name = ? WHERE category_id=?";
    private static final String deleteAdvertisementById = "DELETE FROM advertisement WHERE advertisement_id=?";

    public static String getInsertNewCategory() {
        return insertNewCategory;
    }

    public static String getSelectAllCategories() {
        return selectAllCategories;
    }

    public static String getInsertNewAdvertisement() {
        return insertNewAdvertisement;
    }

    public static String getSelectAllAdvertisement() {
        return selectAllAdvertisement;
    }

    public static String getSelectAllAdvertisementAyCategoryId() {
        return selectAllAdvertisementByCategoryId;
    }

    public static String getUpdateAdvertisementName() {
        return updateAdvertisementName;
    }

    public static String getUpdateCategoryName() {
        return updateCategoryName;
    }

    public static String getDeleteAdvertisementById() {
        return deleteAdvertisementById;
    }

}
