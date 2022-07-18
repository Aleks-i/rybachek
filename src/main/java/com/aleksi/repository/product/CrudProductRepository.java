package com.aleksi.repository.product;

import com.aleksi.model.product.AbstractProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface CrudProductRepository<T extends AbstractProductEntity> extends JpaRepository<T, Integer> {
}