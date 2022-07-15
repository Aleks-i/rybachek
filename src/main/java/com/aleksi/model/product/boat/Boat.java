package com.aleksi.model.product.boat;

import com.aleksi.model.AbstractProductEntity;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "boats")
public class Boat extends AbstractProductEntity {

    @Column(name = "length")
    @NotNull
    private double length;

    @Column(name = "capacity")
    @Range(min = 10, max = 2000)
    private int capacity;

    @Column(name = "pass_count")
    @Range(min = 1, max = 5)
    private int passengersCount;

    @Enumerated(EnumType.STRING)
    @Column(name = "boats_brand")
    private BoatBrand boatBrand;

    public Boat() {
    }

    public Boat(Boat boat) {
        this(boat.id, boat.name, boat.price, boat.count, boat.description, boat.length, boat.capacity,
                boat.passengersCount, boat.boatBrand);
    }

    public Boat(Integer id, String name, double price, int count, String description, double length, int capacity,
                int passengersCount, BoatBrand boatBrand) {
        super(id, name, price, count, description);
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

    public void setLength(double length) {
        this.length = length;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getPassengers() {
        return passengersCount;
    }

    public void setPassengersCount(int passengersCount) {
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