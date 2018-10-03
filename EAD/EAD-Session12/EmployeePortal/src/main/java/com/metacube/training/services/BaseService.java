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
    public T getById(int id);

    public List<T> getAll();

    public Status create(T entity);

    public Status update(T entity);

    public Status delete(int id);
}
