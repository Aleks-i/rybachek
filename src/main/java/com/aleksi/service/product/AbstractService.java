package com.aleksi.service.product;

import com.aleksi.model.product.AbstractProductEntity;
import com.aleksi.repository.product.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import java.util.List;

import static com.aleksi.util.ValidationUtil.checkNotFoundWithId;

public abstract class AbstractService<T extends AbstractProductEntity> implements ProductService<T> {
    protected final Logger log = LoggerFactory.getLogger(getClass());

    ProductRepository<T> productRepository;

    @Override
    public T create(T entity, int userId) {
        log.info("create entity {}", entity);
        Assert.notNull(entity, "maus not be null");
        return checkNotFoundWithId(productRepository.save(entity, userId), userId);
    }

    @Override
    public void update(T entity, int userId) {
        log.info("update entity {}", entity);
        Assert.notNull(entity, "meal must not be null");
        checkNotFoundWithId(productRepository.save(entity, userId), entity.id());
    }

    @Override
    public void delete(int id, int userId) {
        log.info("delete entity id {}", id);
        checkNotFoundWithId(productRepository.delete(id, userId), id);
    }

    @Override
    public T get(int id) {
        log.info("get entity id {}", id);
        return checkNotFoundWithId(productRepository.get(id), id);
    }

    @Override
    public List<T> getAll() {
        log.info("get all entities");
        return productRepository.getAll();
    }
}