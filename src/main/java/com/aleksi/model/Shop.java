package com.aleksi.model;

import com.aleksi.model.user.User;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;

public class Shop extends AbstractBaseEntity {

    private Set<User> users;

    public Shop() {
    }

    public Shop(Shop shop) {
        this(shop.id, shop.name, shop.users);
    }

    public Shop(Integer id, String name, User... users) {
        this(id, name, Arrays.asList(users));
    }

    public Shop(Integer id, String name, Collection<User> users) {
        super(id, name);
        setUsers(users);
    }

    public void setUsers(Collection<User> users) {
        this.users = CollectionUtils.isEmpty(users) ? Collections.emptySet() : Set.copyOf(users);
    }
}