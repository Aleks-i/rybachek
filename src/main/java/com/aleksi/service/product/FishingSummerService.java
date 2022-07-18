package com.aleksi.service.product;

import com.aleksi.model.product.fishing.FishingSummer;
import com.aleksi.repository.product.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class FishingSummerService extends AbstractService<FishingSummer> {

    public FishingSummerService(ProductRepository<FishingSummer> productRepository) {
        this.productRepository = productRepository;
    }
}