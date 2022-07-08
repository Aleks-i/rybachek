package com.aleksi.model;

public class Shop extends AbstractBaseEntity {

    public Shop() {
    }

    public Shop(Shop shop) {
        this(shop.id, shop.name);
    }

    public Shop(Integer id, String name) {
        super(id, name);
    }
}