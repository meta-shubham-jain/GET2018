package com.metacube.advertisementwebservices.model;

/**
 * Class containing the category entities
 */
public class Category extends BaseEntity {
    private String name;

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

}
