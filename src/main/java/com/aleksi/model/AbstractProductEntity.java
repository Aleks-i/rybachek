package com.aleksi.model;

import com.aleksi.model.product.TypesOfProducts;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.EnumSet;
import java.util.Set;

public abstract class AbstractProductEntity extends AbstractBaseEntity {

    protected static final Integer TEMPORARY_ARTICLE = 0;

    protected int article = TEMPORARY_ARTICLE;

    protected double price;

    protected int count;

    protected String description;

    protected Set<TypesOfProducts> typesOfProducts;

    public AbstractProductEntity() {
    }

    public AbstractProductEntity(Integer id, String name, int article, double price, int count, String description,
                                 Collection<TypesOfProducts> typesOfProducts) {
        super(id, name);
        this.article = article;
        this.price = price;
        this.count = count;
        this.description = description;
        setTypesOfProducts(typesOfProducts);
    }

    public int getArticle() {
        return article;
    }

    public void setArticle(int article) {
        this.article = article;
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

    public Set<TypesOfProducts> getTypesOfProducts() {
        return typesOfProducts;
    }

    public void setTypesOfProducts(Collection<TypesOfProducts> typesOfProducts) {
        this.typesOfProducts = CollectionUtils.isEmpty(typesOfProducts) ? EnumSet.noneOf(TypesOfProducts.class)
                : EnumSet.copyOf(typesOfProducts);
    }

    @Override
    public String toString() {
        return super.toString() +
                ", article=" + article +
                ", price=" + price +
                ", count=" + count +
                ", description='" + description + '\'' +
                ", typesOfProducts=" + typesOfProducts;
    }
}