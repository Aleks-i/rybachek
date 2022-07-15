package com.aleksi.service;

import com.aleksi.AbstractServiceTest;
import com.aleksi.model.product.clothes.Clothes;
import com.aleksi.util.exception.NotFoundException;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static com.aleksi.testdata.ClothesTestData.NOT_FOUND;
import static com.aleksi.testdata.ClothesTestData.*;
import static com.aleksi.testdata.UserTestData.*;
import static org.junit.Assert.assertThrows;

public class ClothesServiceTest extends AbstractServiceTest {

    @Autowired
    ClothesService service;

    @Test
    public void createAdmin() {
        Clothes created = service.create(getNewClothes(), ADMIN_ID);
        int newId = created.id();
        Clothes newClothes = getNewClothes();
        newClothes.setId(newId);
        CLOTHES_MATCHER.assertMatch(created, newClothes);
        CLOTHES_MATCHER.assertMatch(service.get(newId), newClothes);
    }

    @Test
    public void createModerator() {
        Clothes created = service.create(getNewClothes(), MODERATOR_ID);
        int newId = created.id();
        Clothes newBoat = getNewClothes();
        newBoat.setId(newId);
        CLOTHES_MATCHER.assertMatch(created, newBoat);
        CLOTHES_MATCHER.assertMatch(service.get(newId), newBoat);
    }

    @Test
    public void createWithUserId() {
        assertThrows(NotFoundException.class, () -> service.create(getNewClothes(), USER_ID));
    }

    @Test
    public void updateAdmin() {
        Clothes updated = getUpdatedClothes();
        service.update(updated, ADMIN_ID);
        CLOTHES_MATCHER.assertMatch(service.get(CLOTHES_ID_1), getUpdatedClothes());
    }

    @Test
    public void updateModerator() {
        Clothes updated = getUpdatedClothes();
        service.update(updated, MODERATOR_ID);
        CLOTHES_MATCHER.assertMatch(service.get(CLOTHES_ID_1), getUpdatedClothes());
    }

    @Test
    public void updateUser() {
        Clothes updated = getUpdatedClothes();
        assertThrows(NotFoundException.class, () -> service.update(updated, USER_ID));
    }

    @Test
    public void deleteAdmin() {
        service.delete(CLOTHES_ID_1, ADMIN_ID);
        assertThrows(NotFoundException.class, () -> service.get(CLOTHES_ID_1));
    }

    @Test
    public void deleteModerator() {
        service.delete(CLOTHES_ID_1, MODERATOR_ID);
        assertThrows(NotFoundException.class, () -> service.get(CLOTHES_ID_1));
    }


    @Test
    public void deleteUser() {
        assertThrows(NotFoundException.class, () -> service.delete(CLOTHES_ID_1, USER_ID));
    }

    @Test
    public void deleteNotFound() {
        assertThrows(NotFoundException.class, () -> service.delete(NOT_FOUND, ADMIN_ID));
    }

    @Test
    public void get() {
        Clothes clothes = service.get(CLOTHES_ID_1);
        CLOTHES_MATCHER.assertMatch(clothes, CLOTHES_1);
    }

    @Test
    public void getNotFound() {
        assertThrows(NotFoundException.class, () -> service.get(NOT_FOUND));
    }

    @Test
    public void getAll() {
        CLOTHES_MATCHER.assertMatch(service.getAll(), getAllClothes());
    }
}