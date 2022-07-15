package com.aleksi.repository;

import java.util.List;

public interface ProductRepository<T> {
    // null if updated meal does not belong to userId
    T save(T etnity, int userId);

    // false if meal does not belong to userId
    boolean delete(int id, int userId);

    // null if meal does not belong to userId
    T get(int id);

    // ORDERED name
    List<T> getAll();
}