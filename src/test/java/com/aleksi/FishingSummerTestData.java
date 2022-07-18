package com.aleksi;

import com.aleksi.model.AbstractBaseEntity;
import com.aleksi.model.product.fishing.FishingSummer;
import com.aleksi.model.product.fishing.FishingSummerType;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.aleksi.model.AbstractBaseEntity.START_SEQ;

@Component
public class FishingSummerTestData implements TestData<FishingSummer> {
    public static final MatcherFactory.Matcher<FishingSummer> FISHING_SUMMER_MATCHER = MatcherFactory
            .usingIgnoringFieldsComparator();

    public static final int FISHING_SUMMER_ID_1 = START_SEQ + 17;
    public static final int FISHING_SUMMER_ID_2 = START_SEQ + 18;
    public static final int FISHING_SUMMER_ID_3 = START_SEQ + 19;
    public static final int FISHING_SUMMER_ID_4 = START_SEQ + 20;
    public static final int NOT_FOUND = 10;

    public static final FishingSummer FISHING_SUMMER_1 = new FishingSummer(FISHING_SUMMER_ID_1, "Крючки",
            50.0, 15, "Крючек на карпа", FishingSummerType.HOOKS);
    public static final FishingSummer FISHING_SUMMER_2 = new FishingSummer(FISHING_SUMMER_ID_2, "Крючки",
            40.0, 13, "Крючек на окуня", FishingSummerType.HOOKS);
    public static final FishingSummer FISHING_SUMMER_3 = new FishingSummer(FISHING_SUMMER_ID_3, "Поплавки",
            60.0, 10, "Поплавки перьевые", FishingSummerType.FLOATS);
    public static final FishingSummer FISHING_SUMMER_4 = new FishingSummer(FISHING_SUMMER_ID_4, "Грузила наборные",
            80.0, 10, "Грузила 10-15-20 гр.", FishingSummerType.SINKERS);


    public FishingSummer getNew() {
        return new FishingSummer(null, "New", 100.0, 2, "Совсем новый крючек",
                FishingSummerType.HOOKS);
    }

    public FishingSummer getUpdated() {
        FishingSummer updatedFishingSummer = new FishingSummer(FISHING_SUMMER_1);
        updatedFishingSummer.setName("Обновленная");
        updatedFishingSummer.setPrice(10.35);
        updatedFishingSummer.setCount(3);
        updatedFishingSummer.setDescription("Обновляем все");
        updatedFishingSummer.setTypesOfFishingSummerPosition(FishingSummerType.FISHING_LINES);
        return updatedFishingSummer;
    }

    @Override
    public int getEntityIdOne() {
        return FISHING_SUMMER_ID_1;
    }

    @Override
    public FishingSummer getEntityOne() {
        return FISHING_SUMMER_1;
    }

    @Override
    public int getEntityIdNotFound() {
        return NOT_FOUND;
    }

    public List<FishingSummer> getAll() {
        return Stream.of(FISHING_SUMMER_1, FISHING_SUMMER_2, FISHING_SUMMER_3, FISHING_SUMMER_4)
                .sorted(Comparator.comparing(AbstractBaseEntity::getName, String.CASE_INSENSITIVE_ORDER))
                .collect(Collectors.toList());
    }

    @Override
    public MatcherFactory.Matcher<FishingSummer> getMatcher() {
        return FISHING_SUMMER_MATCHER;
    }
}