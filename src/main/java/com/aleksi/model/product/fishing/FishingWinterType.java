package com.aleksi.model.product.fishing;

public enum FishingWinterType {
    FLOATS("Поплавки зимние"),
    TENTS("Палатки зимние"),
    MORMYSHKI("Мормышки"),
    FISHING_RODS("Удочки зимние"),
    BOXES("Ящики/Каны"),
    SPINNERS("Блёсны"),
    ZHERLITSY("Жерлицы"),
    SCOOPS("Черпаки/Багры"),
    FEEDERS("Кормушки"),
    ICE_AXEC("Ледорубы");

    private final String name;

    FishingWinterType(String name) {
        this.name = name;
    }
}