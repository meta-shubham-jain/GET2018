package com.metacube.advertisementwebservices.facade;

import java.util.List;

import com.metacube.advertisementwebservices.dao.*;
import com.metacube.advertisementwebservices.model.Category;

/**
 * Facade class for Category
 */
public class CategoryFacade {

    private static CategoryFacade categoryFacade = new CategoryFacade();

    private CategoryDao categoryDao = CategoryDao.getInstance();

    /**
     * Class to create singleton object
     * 
     * @return object
     */
    public static CategoryFacade getInstance() {
        return categoryFacade;
    }

    /**
     * Function to return status for insertion
     * 
     * @param name
     * @return status
     */
    public Status insertCategory(String name) {
        List<Category> categoryList = categoryDao.getAll();

        for (Category category : categoryList) {
            if (category.getName().equals(name)) {
                return Status.DUPLICATE;
            }
        }
        Status status = categoryDao.insert(name);
        if (Status.INSERTED.equals(status)) {
            return Status.INSERTED;
        }
        return Status.NOT_INSERTED;
    }

    /**
     * Function to return the list of category
     * 
     * @return
     */
    public List<Category> getAll() {
        return categoryDao.getAll();
    }

    /**
     * Function to return the status for updated
     * 
     * @param category
     * @param id
     * @return status
     */
    public Status updateCategory(String category, int id) {
        Status status = categoryDao.updateCategory(category, id);
        if (Status.UPDATED.equals(status)) {
            return Status.UPDATED;
        }
        return Status.NOT_UPDATED;
    }
}