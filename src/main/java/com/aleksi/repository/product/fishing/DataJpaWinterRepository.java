package com.aleksi.repository.product.fishing;

import com.aleksi.model.product.fishing.FishingWinter;
import com.aleksi.repository.product.AbstractRepository;
import com.aleksi.repository.product.CrudProductRepository;
import com.aleksi.repository.user.CrudUserRepository;
import org.springframework.stereotype.Repository;

@Repository
public class DataJpaWinterRepository extends AbstractRepository<FishingWinter> {
    public String query = "DELETE FROM FishingWinter fw WHERE fw.id=:id";

    public DataJpaWinterRepository(CrudProductRepository<FishingWinter> crudProductRepository, CrudUserRepository crudUserRepository) {
        this.crudProductRepository = crudProductRepository;
        this.crudUserRepository = crudUserRepository;
        super.query = query;
    }
}