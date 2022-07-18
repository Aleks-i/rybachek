package com.aleksi.repository.product.tourism;

import com.aleksi.model.product.tourism.Tourism;
import com.aleksi.repository.product.AbstractRepository;
import com.aleksi.repository.product.CrudProductRepository;
import com.aleksi.repository.user.CrudUserRepository;
import org.springframework.stereotype.Repository;

@Repository
public class DataJpaTourismRepository extends AbstractRepository<Tourism> {
    public String query = "DELETE FROM Tourism t WHERE t.id=:id";

    public DataJpaTourismRepository(CrudProductRepository<Tourism> crudProductRepository, CrudUserRepository crudUserRepository) {
        this.crudProductRepository = crudProductRepository;
        this.crudUserRepository = crudUserRepository;
        super.query = query;
    }
}