package com.aleksi;

import com.aleksi.model.AbstractBaseEntity;
import com.aleksi.model.product.boat.Boat;
import com.aleksi.model.product.boat.BoatBrand;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.aleksi.model.AbstractBaseEntity.START_SEQ;

@Component
public class BoatTestData implements TestData<Boat> {
    public static final MatcherFactory.Matcher<Boat> BOAT_MATCHER = MatcherFactory
            .usingIgnoringFieldsComparator();

    public static final int BOAT_ID_1 = START_SEQ + 3;
    public static final int BOAT_ID_2 = START_SEQ + 4;
    public static final int BOAT_ID_3 = START_SEQ + 5;
    public static final int BOAT_ID_4 = START_SEQ + 6;
    public static final int BOAT_ID_5 = START_SEQ + 7;
    public static final int BOAT_ID_6 = START_SEQ + 8;
    public static final int BOAT_ID_7 = START_SEQ + 9;
    public static final int BOAT_ID_8 = START_SEQ + 10;
    public static final int BOAT_ID_9 = START_SEQ + 11;
    public static final int NOT_FOUND = 10;
    public static final Boat BOAT_1 = new Boat(BOAT_ID_1, "АКВА ОПТИМА 260", 14000, 1,
            "Лодка ПВХ надувная зеленый", 260, 220, 2, BoatBrand.AKVA);
    public static final Boat BOAT_2 = new Boat(BOAT_ID_2, "АКВА МАСТЕР 280", 17700, 2,
            "Лодка ПВХ надувная зеленый", 280, 220, 2, BoatBrand.AKVA);
    public static final Boat BOAT_3 = new Boat(BOAT_ID_3, "АКВА ОПТИМА 220", 12400, 3,
            "Лодка ПВХ надувная зеленый", 220, 170, 1, BoatBrand.AKVA);
    public static final Boat BOAT_4 = new Boat(BOAT_ID_4, "Аква оптима 190 с гребками", 9900, 4,
            "Самая маленькая и легкая лодка ПВХ", 190, 120, 1, BoatBrand.AKVA);
    public static final Boat BOAT_5 = new Boat(BOAT_ID_5, "Аква оптима 240", 13600, 4,
            "Надувная лодка ПВХ", 240, 220, 2, BoatBrand.AKVA);
    public static final Boat BOAT_6 = new Boat(BOAT_ID_6, "Лоцман C-200 ГР", 9000, 4,
            "Лоцман серый", 200, 120, 1, BoatBrand.LOCMAN);
    public static final Boat BOAT_7 = new Boat(BOAT_ID_7, "Лоцман Профи 260", 14700, 3,
            "Лоцман серый", 260, 220, 2, BoatBrand.LOCMAN);
    public static final Boat BOAT_8 = new Boat(BOAT_ID_8, "Лоцман Стандарт 240", 15400, 2,
            "Надуваня лодка Лоцман серый", 240, 220, 2, BoatBrand.LOCMAN);
    public static final Boat BOAT_9 = new Boat(BOAT_ID_9, "Румб 280", 17300, 2,
            "Надуваня лодка Румб серый/зеленый", 280, 220, 2, BoatBrand.RUMB);

    public Boat getNew() {
        return new Boat(null, "New", 10000, 2, "Совсем новая лодка",
                280, 150, 2, BoatBrand.AKVA);
    }

    public Boat getUpdated() {
        Boat updatedBoat = new Boat(BOAT_1);
        updatedBoat.setName("Обновленная");
        updatedBoat.setPrice(10.35);
        updatedBoat.setCount(3);
        updatedBoat.setDescription("Обновляем все");
        updatedBoat.setLength(300.00);
        updatedBoat.setCapacity(200);
        updatedBoat.setPassengersCount(4);
        updatedBoat.setBoatBrand(BoatBrand.RUMB);
        return updatedBoat;
    }

    @Override
    public int getEntityIdOne() {
        return BOAT_ID_1;
    }

    @Override
    public Boat getEntityOne() {
        return BOAT_1;
    }

    @Override
    public int getEntityIdNotFound() {
        return NOT_FOUND;
    }

    public List<Boat> getAll() {
        return Stream.of(BOAT_1, BOAT_2, BOAT_3, BOAT_4, BOAT_5, BOAT_6, BOAT_7, BOAT_8, BOAT_9)
                .sorted(Comparator.comparing(AbstractBaseEntity::getName, String.CASE_INSENSITIVE_ORDER))
                .collect(Collectors.toList());
    }

    @Override
    public MatcherFactory.Matcher<Boat> getMatcher() {
        return BOAT_MATCHER;
    }
}