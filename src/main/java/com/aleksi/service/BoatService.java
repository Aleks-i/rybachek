package com.aleksi.service;

import com.aleksi.model.product.boat.Boat;
import com.aleksi.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class BoatService extends AbstractService<Boat> {

    public BoatService(ProductRepository<Boat> boatProductRepository) {
        this.productRepository = boatProductRepository;
    }
}