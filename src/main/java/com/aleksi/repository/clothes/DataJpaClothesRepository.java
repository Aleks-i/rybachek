package com.aleksi.repository.clothes;

import com.aleksi.model.product.clothes.Clothes;
import com.aleksi.repository.ProductRepository;
import com.aleksi.repository.user.CrudUserRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.aleksi.util.SortUtil.SORT_NAME;

@Repository
public class DataJpaClothesRepository implements ProductRepository<Clothes> {

    private final CrudClothesRepository crudClothesRepository;
    private final CrudUserRepository crudUserRepository;

    public DataJpaClothesRepository(CrudClothesRepository crudClothesRepository, CrudUserRepository crudUserRepository) {
        this.crudClothesRepository = crudClothesRepository;
        this.crudUserRepository = crudUserRepository;
    }

    @Override
    @Transactional
    public Clothes save(Clothes clothes, int userId) {
        if ((!clothes.isNew() && get(clothes.id()) == null) || !crudUserRepository.checkRoleAdminOrModerator(userId)) {
            return null;
        }
        return crudClothesRepository.save(clothes);
    }

    @Override
    public boolean delete(int id, int userId) {
        return crudClothesRepository.delete(id) != 0 && crudUserRepository.checkRoleAdminOrModerator(userId);
    }

    @Override
    public Clothes get(int id) {
        return crudClothesRepository.findById(id).orElse(null);
    }

    @Override
    public List<Clothes> getAll() {
        return crudClothesRepository.findAll(SORT_NAME);
    }
}