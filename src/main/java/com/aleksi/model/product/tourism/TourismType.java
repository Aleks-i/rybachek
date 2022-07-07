package com.aleksi.model.product.tourism;

public enum TourismType {
    BAGS("Рюкзаки/Сумки"),
    THERMOS("Термосы/Термокружки"),
    TENTS("Палатки"),
    FLASHLIGHTS("Фонари"),
    BINOCULARS("Бинокли"),
    INSECT_REPELLENTS("Средства от насекомых"),
    BARBECUES("Мангалы/треноги"),
    MATTRESSES("Матрасы/Аксессуары"),
    FURNITURE("Столы/Кресла/Стулья");

    private final String name;

    TourismType(String name) {
        this.name = name;
    }
}