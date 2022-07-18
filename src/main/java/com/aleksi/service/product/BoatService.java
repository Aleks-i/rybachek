package com.aleksi.service.product;

import com.aleksi.model.product.boat.Boat;
import com.aleksi.repository.product.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class BoatService extends AbstractService<Boat> {

    public BoatService(ProductRepository<Boat> productRepository) {
        this.productRepository = productRepository;
    }
}