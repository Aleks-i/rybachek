package com.aleksi.model.product.fishing;

import com.aleksi.model.AbstractProductEntity;
import com.aleksi.model.product.TypesOfProducts;

import java.util.Arrays;
import java.util.Collection;

public class FishingSummer extends AbstractProductEntity {

    private FishingSummerType typesOfFishingSummerPosition;

    public FishingSummer() {
    }

    public FishingSummer(FishingSummer fishingSummer) {
        this(fishingSummer.id, fishingSummer.name, fishingSummer.article, fishingSummer.price, fishingSummer.count,
                fishingSummer.description, fishingSummer.typesOfFishingSummerPosition, fishingSummer.typesOfProducts);
    }

    public FishingSummer(Integer id, String name, int article, Double price, int count, String description,
                         FishingSummerType typesOfFishingSummerPosition, TypesOfProducts... typesOfProducts) {
        this(id, name, article, price, count, description, typesOfFishingSummerPosition, Arrays.asList(typesOfProducts));
    }

    public FishingSummer(Integer id, String name, int article, Double price, int count, String description,
                         FishingSummerType typesOfFishingSummerPosition, Collection<TypesOfProducts> typesOfProducts) {
        super(id, name, article, price, count, description, typesOfProducts);
        this.typesOfFishingSummerPosition = typesOfFishingSummerPosition;
    }

    public FishingSummerType getTypesOfFishingSummerPosition() {
        return typesOfFishingSummerPosition;
    }

    public void setTypesOfFishingSummerPosition(FishingSummerType typesOfFishingSummerPosition) {
        this.typesOfFishingSummerPosition = typesOfFishingSummerPosition;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", fishingSummerTypes=" + typesOfFishingSummerPosition +
                '}';
    }
}