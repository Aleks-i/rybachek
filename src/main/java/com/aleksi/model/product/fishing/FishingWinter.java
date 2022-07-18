package com.aleksi.model.product.fishing;

import com.aleksi.model.product.AbstractProductEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "fishing_winter")
public class FishingWinter extends AbstractProductEntity {

    @Enumerated(EnumType.STRING)
    @Column(name = "fishing_winter_type")
    @NotNull
    private FishingWinterType typesOfFishingWinterPosition;

    public FishingWinter() {
    }

    public FishingWinter(FishingWinter fishingWinter) {
        this(fishingWinter.id, fishingWinter.name, fishingWinter.price, fishingWinter.count,
                fishingWinter.description, fishingWinter.typesOfFishingWinterPosition);
    }

    public FishingWinter(Integer id, String name, Double price, int count, String description,
                         FishingWinterType typesOfFishingWinterPosition) {
        super(id, name, price, count, description);
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