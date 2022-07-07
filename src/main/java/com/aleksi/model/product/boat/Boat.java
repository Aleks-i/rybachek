package com.aleksi.model.product.boat;

import com.aleksi.model.AbstractProductEntity;
import com.aleksi.model.product.TypesOfProducts;

import java.util.Arrays;
import java.util.Collection;

public class Boat extends AbstractProductEntity {

    private double length;

    private int capacity;

    private PassengersCount passengersCount;

    private BoatBrand boatBrand;

    public Boat() {
    }

    public Boat(Boat boat) {
        this(boat.id, boat.name, boat.article, boat.price, boat.count, boat.description, boat.length, boat.capacity,
                boat.passengersCount, boat.boatBrand, boat.typesOfProducts);
    }

    public Boat(Integer id, String name, int article, double price, int count, String description, double length, int capacity,
                PassengersCount passengersCount, BoatBrand boatBrand, TypesOfProducts... typesOfProducts) {
        this(id, name, article, price, count, description, length, capacity, passengersCount, boatBrand, Arrays.asList(typesOfProducts));
    }

    public Boat(Integer id, String name, int article, double price, int count, String description, double length, int capacity,
                PassengersCount passengersCount, BoatBrand boatBrand, Collection<TypesOfProducts> typesOfProducts) {
        super(id, name, article, price, count, description, typesOfProducts);
        this.length = length;
        this.capacity = capacity;
        this.passengersCount = passengersCount;
        this.boatBrand = boatBrand;
    }

    public BoatBrand getBoatBrand() {
        return boatBrand;
    }

    public void setBoatBrand(BoatBrand boatBrand) {
        this.boatBrand = boatBrand;
    }

    public double getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public PassengersCount getPassengers() {
        return passengersCount;
    }

    public void setPassengers(PassengersCount passengersCount) {
        this.passengersCount = passengersCount;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", length=" + length +
                ", capacity=" + capacity +
                ", passengers=" + passengersCount +
                ", typesOfBoat=" + boatBrand +
                '}';
    }
}