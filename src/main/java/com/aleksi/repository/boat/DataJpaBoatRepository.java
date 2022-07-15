package com.aleksi.repository.boat;

import com.aleksi.model.product.boat.Boat;
import com.aleksi.repository.ProductRepository;
import com.aleksi.repository.user.CrudUserRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.aleksi.util.SortUtil.SORT_NAME;

@Repository
public class DataJpaBoatRepository implements ProductRepository<Boat> {

    private final CrudBoatRepository crudBoatRepository;
    private final CrudUserRepository crudUserRepository;

    public DataJpaBoatRepository(CrudBoatRepository crudBoatRepository, CrudUserRepository crudUserRepository) {
        this.crudBoatRepository = crudBoatRepository;
        this.crudUserRepository = crudUserRepository;
    }

    @Override
    @Transactional
    public Boat save(Boat boat, int userId) {
        if ((!boat.isNew() && get(boat.id()) == null) || !crudUserRepository.checkRoleAdminOrModerator(userId)) {
            return null;
        }
        return crudBoatRepository.save(boat);
    }

    @Override
    @Transactional
    public boolean delete(int id, int userId) {
        return crudBoatRepository.delete(id) != 0 && crudUserRepository.checkRoleAdminOrModerator(userId);
    }

    @Override
    public Boat get(int id) {
        return crudBoatRepository.findById(id).orElse(null);
    }

    @Override
    public List<Boat> getAll() {
        return crudBoatRepository.findAll(SORT_NAME);
    }
}