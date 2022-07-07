package com.aleksi.model.product.tourism;

import com.aleksi.model.AbstractProductEntity;
import com.aleksi.model.product.TypesOfProducts;

import java.util.Arrays;
import java.util.Collection;

public class Tourism extends AbstractProductEntity {

    private TourismType typesOfTourismPosition;

    public Tourism() {
    }

    public Tourism(Tourism tourism) {
        this(tourism.id, tourism.name, tourism.article, tourism.price, tourism.count, tourism.description,
                tourism.typesOfTourismPosition, tourism.typesOfProducts);
    }

    public Tourism(Integer id, String name, int article, Double price, int count, String description,
                   TourismType typesOfTourismPosition, TypesOfProducts... typesOfProducts) {
        this(id, name, article, price, count, description, typesOfTourismPosition, Arrays.asList(typesOfProducts));
    }

    public Tourism(Integer id, String name, int article, Double price, int count, String description,
                   TourismType typesOfTourismPosition, Collection<TypesOfProducts> typesOfProducts) {
        super(id, name, article, price, count, description, typesOfProducts);
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