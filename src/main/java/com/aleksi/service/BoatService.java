package com.aleksi.service;

import com.aleksi.model.product.boat.Boat;
import com.aleksi.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

import static com.aleksi.util.ValidationUtil.checkNotFoundWithId;

@Service
public class BoatService {

    private final ProductRepository<Boat> boatProductRepository;

    public BoatService(ProductRepository<Boat> boatProductRepository) {
        this.boatProductRepository = boatProductRepository;
    }

    public Boat create(Boat boat, int userId) {
        Assert.notNull(boat, "maus not be null");
        return checkNotFoundWithId(boatProductRepository.save(boat, userId), userId);
    }

    public void update(Boat boat, int userId) {
        Assert.notNull(boat, "meal must not be null");
        checkNotFoundWithId(boatProductRepository.save(boat, userId), boat.id());
    }


    public void delete(int id, int userId) {
        checkNotFoundWithId(boatProductRepository.delete(id, userId), id);
    }

    public Boat get(int id) {
        return checkNotFoundWithId(boatProductRepository.get(id), id);
    }

    public List<Boat> getAll() {
        return boatProductRepository.getAll();
    }
}