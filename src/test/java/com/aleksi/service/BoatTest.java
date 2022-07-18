package com.aleksi.service;

import com.aleksi.AbstractProductServiceTest;
import com.aleksi.BoatTestData;
import com.aleksi.model.product.boat.Boat;
import com.aleksi.service.product.BoatService;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BoatTest extends AbstractProductServiceTest<Boat> {

    @Autowired
    BoatService service;
    @Autowired
    BoatTestData testData;

    @Before
    public void setUpTestData() {
        super.testData = testData;
        super.service = service;
    }
}