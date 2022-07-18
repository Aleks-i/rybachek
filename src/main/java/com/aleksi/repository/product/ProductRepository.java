package com.aleksi.repository.product;

import com.aleksi.model.product.AbstractProductEntity;

import java.util.List;

public interface ProductRepository<T extends AbstractProductEntity> {
    // null if updated meal does not belong to userId
    T save(T etnity, int userId);

    // false if meal does not belong to userId
    boolean delete(int id, int userId);

    // null if meal does not belong to userId
    T get(int id);

    // ORDERED name
    List<T> getAll();
}