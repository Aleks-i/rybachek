package com.aleksi.model.product.clothes;

import com.aleksi.model.AbstractProductEntity;
import com.aleksi.model.product.TypesOfProducts;

import java.util.Arrays;
import java.util.Collection;

public class Clothes extends AbstractProductEntity {

    private String size;
    private ClothesTypes clothesType;

    public Clothes() {
    }

    public Clothes(Clothes clothes) {
        this(clothes.id, clothes.name, clothes.article, clothes.price, clothes.count, clothes.description, clothes.size,
                clothes.clothesType, clothes.typesOfProducts);
    }

    public Clothes(Integer id, String name, int article, double price, int count, String description, String size,
                   ClothesTypes clothesType, TypesOfProducts... typesOfProducts) {
        this(id, name, article, price, count, description, size, clothesType, Arrays.asList(typesOfProducts));
        this.size = size;
        this.clothesType = clothesType;
    }

    public Clothes(Integer id, String name, int article, double price, int count, String description, String size,
                   ClothesTypes clothesType, Collection<TypesOfProducts> typesOfProducts) {
        super(id, name, article, price, count, description, typesOfProducts);
        this.size = size;
        this.clothesType = clothesType;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public ClothesTypes getClothesType() {
        return clothesType;
    }

    public void setClothesType(ClothesTypes clothesType) {
        this.clothesType = clothesType;
    }

    @Override
    public String toString() {
        return super.toString() +
                "size='" + size + '\'' +
                ", clothesType=" + clothesType +
                '}';
    }
}