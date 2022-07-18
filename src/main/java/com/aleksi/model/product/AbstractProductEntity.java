package com.aleksi.model.product;

import com.aleksi.model.AbstractBaseEntity;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractProductEntity extends AbstractBaseEntity {

    protected double price;

    protected int count;

    protected String description;

    public AbstractProductEntity() {
    }

    public AbstractProductEntity(Integer id, String name, double price, int count, String description) {
        super(id, name);
        this.price = price;
        this.count = count;
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", price=" + price +
                ", count=" + count +
                ", description='" + description + '\'';
    }
}