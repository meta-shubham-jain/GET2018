package com.metacube.advertisementwebservices.facade;

import java.util.List;

import com.metacube.advertisementwebservices.dao.*;
import com.metacube.advertisementwebservices.model.*;

/**
 * Facade Class for advertisement table
 */
public class AdvertisementFacade {
	private static AdvertisementFacade advertisementFacade = new AdvertisementFacade();
	private AdvertisementDao advertisementDao =  AdvertisementDao.getInstance();
	private CategoryDao categoryDao = CategoryDao.getInstance();

	/**
	 * Function to create the singleton object
	 * 
	 * @return object
	 */
	public static AdvertisementFacade getInstance() {
		return advertisementFacade;
	}

	/**
	 * Function to insert the data in the advertisement table
	 * 
	 * @param category_id
	 * @param title
	 * @param description
	 * @return
	 */
	public Status insertAdvertisement(int category_id, String title, String description) {
		Advertisement advertisement = new Advertisement();
		advertisement.setCategoryId(category_id);
		advertisement.setTitle(title);
		advertisement.setDescription(description);
		List<Advertisement> advertisementList = advertisementDao.getAll();
		List<Category> categoryList = categoryDao.getAll();	
		for (Advertisement advert : advertisementList) {
			if (advert.getTitle().equals(advertisement.getTitle())) {
				return Status.DUPLICATE;
			}
		}
		for (Category category : categoryList) {
			if (category.getId() == advertisement.getCategoryId()) {
				advertisementDao.insert(advertisement);
				return Status.INSERTED;
			}
		}
		return Status.INVALID;
	}

	/**
	 * Function to get the list of advertisements
	 * 
	 * @return list of advertisement
	 */
	public List<Advertisement> getAll() {
		return advertisementDao.getAll();
	}

	/**
	 * Function to get the list of advertisements by id
	 * 
	 * @param id
	 * @return list of advertisement
	 */
	public List<Advertisement> getAllById(int id) {
		return advertisementDao.getAllById(id);
	}

	/**
	 * Function to return the status updated
	 * 
	 * @param name
	 * @param id
	 * @return
	 */
	public Status updateName(String name, int id) {
		Status status = advertisementDao.updateName(name, id);
		if (Status.UPDATED.equals(status)) {
		    return Status.UPDATED;
		}
		return Status.NOT_UPDATED;
	}

	/**
	 * Function to return the status deleted
	 * 
	 * @param id
	 * @return
	 */
	public Status deleteAdvertisement(int id) {
		List<Advertisement> advertisementList = advertisementDao.getAll();
		for (Advertisement advert : advertisementList) {
			if (advert.getId() == id) {
				advertisementDao.deleteAdvertisement(id);
				return Status.DELETED;
			}
		}
		return Status.NOT_DELETED;
	}
}
