package com.aleksi.service;

import com.aleksi.AbstractProductServiceTest;
import com.aleksi.FishingWinterTestData;
import com.aleksi.model.product.fishing.FishingWinter;
import com.aleksi.service.product.FishingWinterService;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FishingWinterTest extends AbstractProductServiceTest<FishingWinter> {

    @Autowired
    FishingWinterService service;
    @Autowired
    FishingWinterTestData testData;

    @Before
    public void setUpTestData() {
        super.testData = testData;
        super.service = service;
    }
}