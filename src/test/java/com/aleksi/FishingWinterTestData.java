package com.aleksi;

import com.aleksi.model.AbstractBaseEntity;
import com.aleksi.model.product.fishing.FishingWinter;
import com.aleksi.model.product.fishing.FishingWinterType;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.aleksi.model.AbstractBaseEntity.START_SEQ;

@Component
public class FishingWinterTestData implements TestData<FishingWinter> {
    public static final MatcherFactory.Matcher<FishingWinter> FISHING_WINTER_MATCHER = MatcherFactory
            .usingIgnoringFieldsComparator();

    public static final int FISHING_WINTER_ID_1 = START_SEQ + 21;
    public static final int FISHING_WINTER_ID_2 = START_SEQ + 22;
    public static final int NOT_FOUND = 10;

    public static final FishingWinter FISHING_WINTER_1 = new FishingWinter(FISHING_WINTER_ID_1, "Крючки зимние",
            40.0, 8, "Крючек зимний", FishingWinterType.HOOKS);
    public static final FishingWinter FISHING_WINTER_2 = new FishingWinter(FISHING_WINTER_ID_2, "Удилище зимнее",
            300.0, 7, "Зимняя удочка", FishingWinterType.FISHING_RODS);


    public FishingWinter getNew() {
        return new FishingWinter(null, "New", 100.0, 2, "Совсем новый крючек",
                FishingWinterType.HOOKS);
    }

    public FishingWinter getUpdated() {
        FishingWinter updatedFishingWinter = new FishingWinter(FISHING_WINTER_1);
        updatedFishingWinter.setName("Обновленная");
        updatedFishingWinter.setPrice(11.5);
        updatedFishingWinter.setCount(30);
        updatedFishingWinter.setDescription("Обновляем все подряд");
        updatedFishingWinter.setTypesOfFishingWinterPosition(FishingWinterType.FLOATS);
        return updatedFishingWinter;
    }

    @Override
    public int getEntityIdOne() {
        return FISHING_WINTER_ID_1;
    }

    @Override
    public FishingWinter getEntityOne() {
        return FISHING_WINTER_1;
    }

    @Override
    public int getEntityIdNotFound() {
        return NOT_FOUND;
    }

    public List<FishingWinter> getAll() {
        return Stream.of(FISHING_WINTER_1, FISHING_WINTER_2)
                .sorted(Comparator.comparing(AbstractBaseEntity::getName, String.CASE_INSENSITIVE_ORDER))
                .collect(Collectors.toList());
    }

    @Override
    public MatcherFactory.Matcher<FishingWinter> getMatcher() {
        return FISHING_WINTER_MATCHER;
    }
}