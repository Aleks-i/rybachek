package com.aleksi.repository.product;

import com.aleksi.model.product.AbstractProductEntity;
import com.aleksi.repository.user.CrudUserRepository;
import com.aleksi.util.exception.NotFoundException;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

import static com.aleksi.util.SortUtil.SORT_NAME;

public abstract class AbstractRepository<T extends AbstractProductEntity> implements ProductRepository<T> {

    public String query;

    protected CrudProductRepository<T> crudProductRepository;
    protected CrudUserRepository crudUserRepository;

    @PersistenceContext
    protected EntityManager em;

    @Override
    @Transactional
    public T save(T entity, int userId) {
        if ((!entity.isNew() && get(entity.id()) == null) || !crudUserRepository.isRoleAdminOrModerator(userId)) {
            return null;
        }
        return crudProductRepository.save(entity);
    }

    @Override
    @Transactional
    public boolean delete(int id, int userId) {
        if (!crudUserRepository.isRoleAdminOrModerator(userId)) {
            return false;
        }
        Query q = em.createQuery(query)
                .setParameter("id", id);
        return q.executeUpdate() != 0;
    }

    @Override
    public T get(int id) {
        return crudProductRepository.findById(id).orElse(null);
    }

    @Override
    public List<T> getAll() {
        return crudProductRepository.findAll(SORT_NAME);
    }
}