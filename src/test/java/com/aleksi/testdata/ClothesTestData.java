package com.aleksi.testdata;

import com.aleksi.MatcherFactory;
import com.aleksi.model.AbstractBaseEntity;
import com.aleksi.model.product.clothes.Clothes;
import com.aleksi.model.product.clothes.ClothesTypes;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.aleksi.model.AbstractBaseEntity.START_SEQ;

public class ClothesTestData {
    public static final MatcherFactory.Matcher<Clothes> CLOTHES_MATCHER = MatcherFactory
            .usingIgnoringFieldsComparator();

    public static final int CLOTHES_ID_1 = START_SEQ + 12;
    public static final int CLOTHES_ID_2 = START_SEQ + 13;
    public static final int CLOTHES_ID_3 = START_SEQ + 14;
    public static final int CLOTHES_ID_4 = START_SEQ + 15;
    public static final int CLOTHES_ID_5 = START_SEQ + 16;

    public static final int NOT_FOUND = 10;

    public static final Clothes CLOTHES_1 = new Clothes(CLOTHES_ID_1, "Костюм х/б", 2500, 4,
            "Костюм зимний", "42-43", ClothesTypes.WINTER);
    public static final Clothes CLOTHES_2 = new Clothes(CLOTHES_ID_2, "Валенки", 400, 5,
            "Валеник зимние", "43", ClothesTypes.SHOES);
    public static final Clothes CLOTHES_3 = new Clothes(CLOTHES_ID_3, "Варежки", 500, 4,
            "Ватные варежки", "X", ClothesTypes.WINTER);
    public static final Clothes CLOTHES_4 = new Clothes(CLOTHES_ID_4, "Костюм нательный", 1500, 8,
            "Нательное белье", "XL", ClothesTypes.WINTER);
    public static final Clothes CLOTHES_5 = new Clothes(CLOTHES_ID_5, "Комбинезон защитный", 1300, 6,
            "Защитный дождевик цвет хаки", "XL", ClothesTypes.SUMMER);

    public static Clothes getNewClothes() {
        return new Clothes(null, "New", 10000, 2, "Совсем новая одежда",
                "XXXXL", ClothesTypes.SUMMER);
    }

    public static Clothes getUpdatedClothes() {
        Clothes updatedClothes = new Clothes(CLOTHES_1);
        updatedClothes.setName("Обновленная");
        updatedClothes.setPrice(10.35);
        updatedClothes.setCount(3);
        updatedClothes.setDescription("Обновляем все");
        updatedClothes.setSize("300.00");
        updatedClothes.setClothesType(ClothesTypes.SHOES);
        return updatedClothes;
    }

    public static List<Clothes> getAllClothes() {
        return Stream.of(CLOTHES_1, CLOTHES_2, CLOTHES_3, CLOTHES_4, CLOTHES_5)
                .sorted(Comparator.comparing(AbstractBaseEntity::getName, String.CASE_INSENSITIVE_ORDER))
                .collect(Collectors.toList());
    }
}