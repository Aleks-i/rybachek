package com.aleksi.model.product.tourism;

import com.aleksi.model.product.AbstractProductEntity;
import com.aleksi.model.product.TypesOfProducts;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tourism")
public class Tourism extends AbstractProductEntity {

    @Enumerated(EnumType.STRING)
    @Column(name = "tourism_type")
    @NotNull
    private TourismType typesOfTourismPosition;

    public Tourism() {
    }

    public Tourism(Tourism tourism) {
        this(tourism.id, tourism.name, tourism.price, tourism.count, tourism.description,
                tourism.typesOfTourismPosition);
    }

    public Tourism(Integer id, String name, Double price, int count, String description,
                   TourismType typesOfTourismPosition, TypesOfProducts... typesOfProducts) {
        this(id, name, price, count, description, typesOfTourismPosition);
    }

    public Tourism(Integer id, String name, Double price, int count, String description,
                   TourismType typesOfTourismPosition) {
        super(id, name, price, count, description);
        this.typesOfTourismPosition = typesOfTourismPosition;
    }

    public TourismType getTypesOfTourismPosition() {
        return typesOfTourismPosition;
    }

    public void setTypesOfTourismPosition(TourismType typesOfTourismPosition) {
        this.typesOfTourismPosition = typesOfTourismPosition;
    }

    @Override
    public String toString() {
        return super.toString() +
                "tourismTypes=" + typesOfTourismPosition +
                '}';
    }
}