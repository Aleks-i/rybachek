package com.aleksi.model.product.fishing;

import com.aleksi.model.AbstractProductEntity;
import com.aleksi.model.product.TypesOfProducts;

import java.util.Arrays;
import java.util.Collection;

public class FishingWinter extends AbstractProductEntity {

    private FishingWinterType typesOfFishingWinterPosition;

    public FishingWinter() {
    }

    public FishingWinter(FishingWinter fishingWinter) {
        this(fishingWinter.id, fishingWinter.name, fishingWinter.article, fishingWinter.price, fishingWinter.count,
                fishingWinter.description, fishingWinter.typesOfFishingWinterPosition, fishingWinter.typesOfProducts);
    }

    public FishingWinter(Integer id, String name, int article, Double price, int count, String description,
                         FishingWinterType typesOfFishingWinterPosition, TypesOfProducts... typesOfProducts) {
        this(id, name, article, price, count, description, typesOfFishingWinterPosition, Arrays.asList(typesOfProducts));
    }

    public FishingWinter(Integer id, String name, int article, Double price, int count, String description,
                         FishingWinterType typesOfFishingWinterPosition, Collection<TypesOfProducts> typesOfProducts) {
        super(id, name, article, price, count, description, typesOfProducts);
        this.typesOfFishingWinterPosition = typesOfFishingWinterPosition;
    }

    public FishingWinterType getTypesOfFishingWinterPosition() {
        return typesOfFishingWinterPosition;
    }

    public void setTypesOfFishingWinterPosition(FishingWinterType typesOfFishingWinterPosition) {
        this.typesOfFishingWinterPosition = typesOfFishingWinterPosition;
    }

    @Override
    public String toString() {
        return super.toString() +
                "fishingWinterTypes=" + typesOfFishingWinterPosition +
                '}';
    }
}