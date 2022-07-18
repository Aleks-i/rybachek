package com.aleksi.service.product;

import com.aleksi.model.product.clothes.Clothes;
import com.aleksi.repository.product.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ClothesService extends AbstractService<Clothes> {

    public ClothesService(ProductRepository<Clothes> productRepository) {
        this.productRepository = productRepository;
    }
}