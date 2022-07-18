package com.aleksi.service.product;

import com.aleksi.model.product.fishing.FishingWinter;
import com.aleksi.repository.product.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class FishingWinterService extends AbstractService<FishingWinter> {

    public FishingWinterService(ProductRepository<FishingWinter> productRepository) {
        this.productRepository = productRepository;
    }
}