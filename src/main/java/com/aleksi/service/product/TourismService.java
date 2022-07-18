package com.aleksi.service.product;

import com.aleksi.model.product.tourism.Tourism;
import com.aleksi.repository.product.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class TourismService extends AbstractService<Tourism> {

    public TourismService(ProductRepository<Tourism> productRepository) {
        this.productRepository = productRepository;
    }
}