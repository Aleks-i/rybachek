package com.aleksi;

import com.aleksi.model.AbstractBaseEntity;
import com.aleksi.model.product.boat.Boat;
import com.aleksi.model.product.boat.BoatBrand;
import com.aleksi.model.product.tourism.Tourism;
import com.aleksi.model.product.tourism.TourismType;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.aleksi.model.AbstractBaseEntity.START_SEQ;

@Component
public class TourismTestData implements TestData<Tourism> {
    public static final MatcherFactory.Matcher<Tourism> TOURISM_MATCHER = MatcherFactory
            .usingIgnoringFieldsComparator();

    public static final int TOURISM_ID_1 = START_SEQ + 23;
    public static final int TOURISM_ID_2 = START_SEQ + 24;
    public static final int TOURISM_ID_3 = START_SEQ + 25;
    public static final int NOT_FOUND = 10;

    public static final Tourism TOURISM_1 = new Tourism(TOURISM_ID_1, "Сумка", 560.0, 4,
            "Сумка походная", TourismType.BAGS);
    public static final Tourism TOURISM_2 = new Tourism(TOURISM_ID_2, "Ящик", 600.0, 4,
            "Ящик утепленный", TourismType.BAGS);
    public static final Tourism TOURISM_3 = new Tourism(TOURISM_ID_3, "Мангал", 800.0, 4,
            "Мангал маленький", TourismType.BARBECUES);

    public Tourism getNew() {
        return new Tourism(null, "New", 10000.0, 2, "Совсем новая лодка",
                TourismType.BARBECUES);
    }

    public Tourism getUpdated() {
        Tourism updatedTourism = new Tourism(TOURISM_1);
        updatedTourism.setName("Обновленная");
        updatedTourism.setPrice(10.35);
        updatedTourism.setCount(3);
        updatedTourism.setDescription("Обновляем все");
        updatedTourism.setTypesOfTourismPosition(TourismType.TENTS);
        return updatedTourism;
    }

    @Override
    public int getEntityIdOne() {
        return TOURISM_ID_1;
    }

    @Override
    public Tourism getEntityOne() {
        return TOURISM_1;
    }

    @Override
    public int getEntityIdNotFound() {
        return NOT_FOUND;
    }

    public List<Tourism> getAll() {
        return Stream.of(TOURISM_1, TOURISM_2, TOURISM_3)
                .sorted(Comparator.comparing(AbstractBaseEntity::getName, String.CASE_INSENSITIVE_ORDER))
                .collect(Collectors.toList());
    }

    @Override
    public MatcherFactory.Matcher<Tourism> getMatcher() {
        return TOURISM_MATCHER;
    }
}