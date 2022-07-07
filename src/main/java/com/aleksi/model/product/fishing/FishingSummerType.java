package com.aleksi.model.product.fishing;

public enum FishingSummerType {
    LEASHES("Поводки"),
    COILS("Катушки"),
    HOOKS("Крючки"),
    SINKERS("Грузила"),
    RODS("Удилища"),
    SPININGS("Спининги"),
    FISHING_LINES("Лески"),
    JIGOLOVKI("Джи головки"),
    SUB_CHECKS("Подсачеки"),
    FLOATS("Поплавки"),
    FEEDERS("Кормушки"),
    SPINNERS("Блесны"),
    WOBBLERS("Воблеры"),
    CAGES("Садки"),
    BAITS("Прикормки");


    private final String name;

    FishingSummerType(String name) {
        this.name = name;
    }
}