package com.aleksi.service;

import com.aleksi.TourismTestData;
import com.aleksi.model.product.tourism.Tourism;
import com.aleksi.service.product.TourismService;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;

public class TourismServiceTest extends AbstractProductServiceTest<Tourism> {

    @Autowired
    TourismService service;
    @Autowired
    TourismTestData testData;

    @Before
    public void setUpTestData() {
        super.testData = testData;
        super.service = service;
    }
}