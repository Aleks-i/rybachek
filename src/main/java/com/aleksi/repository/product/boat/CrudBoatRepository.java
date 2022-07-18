package com.aleksi.repository.product.boat;

import com.aleksi.model.product.boat.Boat;
import com.aleksi.repository.product.CrudProductRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface CrudBoatRepository extends CrudProductRepository<Boat> {

}