package com.aleksi.service;

import com.aleksi.model.product.clothes.Clothes;
import com.aleksi.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ClothesService extends AbstractService<Clothes> {

    public ClothesService(ProductRepository<Clothes> clothesProductRepository) {
        this.productRepository = clothesProductRepository;
    }
}