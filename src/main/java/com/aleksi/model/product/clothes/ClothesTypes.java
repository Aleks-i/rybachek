package com.aleksi.model.product.clothes;

public enum ClothesTypes {
    WINTER("Зимняя одежда"),
    SUMMER("Летняя одежда"),
    SHOES("Обувь");

    private final String name;

    ClothesTypes(String name) {
        this.name = name;
    }
}