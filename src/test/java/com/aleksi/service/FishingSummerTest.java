package com.aleksi.service;

import com.aleksi.AbstractProductServiceTest;
import com.aleksi.FishingSummerTestData;
import com.aleksi.model.product.fishing.FishingSummer;
import com.aleksi.service.product.FishingSummerService;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FishingSummerTest extends AbstractProductServiceTest<FishingSummer> {

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