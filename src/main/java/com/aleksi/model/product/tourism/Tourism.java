package com.aleksi.model.product.tourism;

import com.aleksi.model.AbstractProductEntity;
import com.aleksi.model.product.TypesOfProducts;

public class Tourism extends AbstractProductEntity {

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