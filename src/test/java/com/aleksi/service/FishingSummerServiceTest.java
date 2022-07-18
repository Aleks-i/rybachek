package com.aleksi.service;

import com.aleksi.FishingSummerTestData;
import com.aleksi.model.product.fishing.FishingSummer;
import com.aleksi.service.product.FishingSummerService;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;

public class FishingSummerServiceTest extends AbstractProductServiceTest<FishingSummer> {

    @Autowired
    FishingSummerService service;
    @Autowired
    FishingSummerTestData testData;

    @Before
    public void setUpTestData() {
        super.testData = testData;
        super.service = service;
    }
}