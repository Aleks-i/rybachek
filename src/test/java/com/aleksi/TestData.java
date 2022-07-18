package com.aleksi;

import com.aleksi.model.product.AbstractProductEntity;

import java.util.List;

public interface TestData<T extends AbstractProductEntity> {

    T getNew();

    T getUpdated();

    int getEntityIdOne();

    T getEntityOne();

    int getEntityIdNotFound();

    List<T> getAll();

    MatcherFactory.Matcher<T> getMatcher();
}