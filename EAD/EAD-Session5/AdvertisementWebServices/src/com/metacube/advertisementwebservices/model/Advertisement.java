package com.metacube.advertisementwebservices.model;

/**
 * Class containing the advertisement entities
 */
public class Advertisement extends BaseEntity {

    private String title;
    private String description;
    private int categoryId;

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the category_id
     */
    public int getCategoryId() {
        return categoryId;
    }

    /**
     * @param category_id the category_id to set
     */
    public void setCategoryId(int category_id) {
        this.categoryId = category_id;
    }
}
