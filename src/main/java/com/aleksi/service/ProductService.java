package com.aleksi.service;

import com.aleksi.model.AbstractProductEntity;

import java.util.List;

public interface ProductService<T extends AbstractProductEntity> {

    T create(T entity, int userId);

    void update(T entity, int userId);

    void delete(int id, int userId);

    T get(int id);

    List<T> getAll();
}