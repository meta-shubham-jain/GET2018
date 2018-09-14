package com.metacube.training.dao;

import java.util.List;

import com.metacube.training.Status.Status;

/**
 * The class defines an interface which has common methods for all tables
 * 
 * @author Shubham Jain
 *
 * @param <T>
 */
public interface BaseDao<T> {
    public T getById(int id);

    public List<T> getAll();

    public Status create(T entity);

    public Status update(T entity);

    public Status delete(int id);
}
