package com.aleksi.repository.product.clothes;

import com.aleksi.model.product.clothes.Clothes;
import com.aleksi.repository.product.AbstractRepository;
import com.aleksi.repository.product.CrudProductRepository;
import com.aleksi.repository.user.CrudUserRepository;
import org.springframework.stereotype.Repository;

@Repository
public class DataJpaClothesRepository extends AbstractRepository<Clothes> {
    public String query = "DELETE FROM Clothes c WHERE c.id=:id";

    public DataJpaClothesRepository(CrudProductRepository<Clothes> crudProductRepository, CrudUserRepository crudUserRepository) {
        this.crudProductRepository = crudProductRepository;
        this.crudUserRepository = crudUserRepository;
        super.query = query;
    }
}