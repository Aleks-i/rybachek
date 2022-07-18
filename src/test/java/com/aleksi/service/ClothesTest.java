package com.aleksi.service;

import com.aleksi.AbstractProductServiceTest;
import com.aleksi.ClothesTestData;
import com.aleksi.model.product.clothes.Clothes;
import com.aleksi.service.product.ClothesService;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;

public class ClothesTest extends AbstractProductServiceTest<Clothes> {

    @Autowired
    ClothesService service;
    @Autowired
    ClothesTestData testData;

    @Before
    public void setUpTestData() {
        super.testData = testData;
        super.service = service;
    }
}