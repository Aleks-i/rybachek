package com.aleksi.model.product.clothes;

import com.aleksi.model.AbstractProductEntity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "clothes")
public class Clothes extends AbstractProductEntity {

    @Column(name = "size")
    @NotBlank
    private String size;

    @Enumerated(EnumType.STRING)
    @Column(name = "clothes_type")
    @NotNull
    private ClothesTypes clothesType;

    public Clothes() {
    }

    public Clothes(Clothes clothes) {
        this(clothes.id, clothes.name, clothes.price, clothes.count, clothes.description, clothes.size,
                clothes.clothesType);
    }

    public Clothes(Integer id, String name, double price, int count, String description, String size,
                   ClothesTypes clothesType) {
        super(id, name, price, count, description);
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