package com.aleksi.service.product;

import com.aleksi.model.product.AbstractProductEntity;

import java.util.List;

public interface ProductService<T extends AbstractProductEntity> {

    T create(T entity, int userId);

    void update(T entity, int userId);

    void delete(int id, int userId);

    T get(int id);

    List<T> getAll();
}