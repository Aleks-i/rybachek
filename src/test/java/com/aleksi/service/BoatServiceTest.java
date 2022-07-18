package com.aleksi.service;

import com.aleksi.BoatTestData;
import com.aleksi.model.product.boat.Boat;
import com.aleksi.service.product.BoatService;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;

public class BoatServiceTest extends AbstractProductServiceTest<Boat> {

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