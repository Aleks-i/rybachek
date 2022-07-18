package com.aleksi.repository.product.fishing;

import com.aleksi.model.product.fishing.FishingSummer;
import com.aleksi.repository.product.AbstractRepository;
import com.aleksi.repository.product.CrudProductRepository;
import com.aleksi.repository.user.CrudUserRepository;
import org.springframework.stereotype.Repository;

@Repository
public class DataJpaSummerRepository extends AbstractRepository<FishingSummer> {
    public String query = "DELETE FROM FishingSummer fs WHERE fs.id=:id";

    public DataJpaSummerRepository(CrudProductRepository<FishingSummer> crudProductRepository, CrudUserRepository crudUserRepository) {
        this.crudProductRepository = crudProductRepository;
        this.crudUserRepository = crudUserRepository;
        super.query = query;
    }
}