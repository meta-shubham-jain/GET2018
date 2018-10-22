package com.metacube.training.services;

import java.util.List;

import com.metacube.training.Status.Status;

/**
 * The class defines interface of base service
 * 
 * @author Shubham Jain
 *
 * @param <T>
 */
public interface BaseService<T> {

	/**
	 * Get Object by id
	 * 
	 * @param id
	 * @return
	 */
	public T getById(int id);

	/**
	 * Fetch all List
	 * 
	 * @return
	 */
	public List<T> getAll();

	/**
	 * Create entity
	 * 
	 * @param entity
	 * @return
	 */
	public Status create(T entity);

	/**
	 * Update entity
	 * 
	 * @param entity
	 * @return
	 */
	public Status update(T entity);

	/**
	 * Delete Entity
	 * 
	 * @param id
	 * @return
	 */
	public Status delete(int id);
}
