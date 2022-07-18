package com.aleksi.model.product.fishing;

import com.aleksi.model.product.AbstractProductEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "fishing_summer")
public class FishingSummer extends AbstractProductEntity {

    @Enumerated(EnumType.STRING)
    @Column(name = "fishing_summer_type")
    @NotNull
    private FishingSummerType typesOfFishingSummerPosition;

    public FishingSummer() {
    }

    public FishingSummer(FishingSummer fishingSummer) {
        this(fishingSummer.id, fishingSummer.name, fishingSummer.price, fishingSummer.count,
                fishingSummer.description, fishingSummer.typesOfFishingSummerPosition);
    }

    public FishingSummer(Integer id, String name, Double price, int count, String description,
                         FishingSummerType typesOfFishingSummerPosition) {
        super(id, name, price, count, description);
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