package com.aleksi.repository.product.boat;

import com.aleksi.model.product.boat.Boat;
import com.aleksi.repository.product.AbstractRepository;
import com.aleksi.repository.product.CrudProductRepository;
import com.aleksi.repository.user.CrudUserRepository;
import org.springframework.stereotype.Repository;

@Repository
public class DataJpaBoatRepository extends AbstractRepository<Boat> {
    public String query = "DELETE FROM Boat b WHERE b.id=:id";

    public DataJpaBoatRepository(CrudProductRepository<Boat> crudBoatRepository, CrudUserRepository crudUserRepository) {
        this.crudProductRepository = crudBoatRepository;
        this.crudUserRepository = crudUserRepository;
        super.query = query;
    }
}