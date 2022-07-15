package com.aleksi.service;

import com.aleksi.AbstractServiceTest;
import com.aleksi.model.product.boat.Boat;
import com.aleksi.util.exception.NotFoundException;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static com.aleksi.testdata.BoatTestData.NOT_FOUND;
import static com.aleksi.testdata.BoatTestData.*;
import static com.aleksi.testdata.UserTestData.*;
import static org.junit.Assert.assertThrows;

public class BoatServiceTest extends AbstractServiceTest {

    @Autowired
    BoatService service;

    @Test
    public void createAdmin() {
        Boat created = service.create(getNewBoat(), ADMIN_ID);
        int newId = created.id();
        Boat newBoat = getNewBoat();
        newBoat.setId(newId);
        BOAT_MATCHER.assertMatch(created, newBoat);
        BOAT_MATCHER.assertMatch(service.get(newId), newBoat);
    }

    @Test
    public void createModerator() {
        Boat created = service.create(getNewBoat(), MODERATOR_ID);
        int newId = created.id();
        Boat newBoat = getNewBoat();
        newBoat.setId(newId);
        BOAT_MATCHER.assertMatch(created, newBoat);
        BOAT_MATCHER.assertMatch(service.get(newId), newBoat);
    }

    @Test
    public void createWithUserId() {
        assertThrows(NotFoundException.class, () -> service.create(getNewBoat(), USER_ID));
    }

    @Test
    public void updateAdmin() {
        Boat updated = getUpdatedBoat();
        service.update(updated, ADMIN_ID);
        BOAT_MATCHER.assertMatch(service.get(BOAT_ID_1), getUpdatedBoat());
    }

    @Test
    public void updateModerator() {
        Boat updated = getUpdatedBoat();
        service.update(updated, MODERATOR_ID);
        BOAT_MATCHER.assertMatch(service.get(BOAT_ID_1), getUpdatedBoat());
    }

    @Test
    public void updateUser() {
        Boat updated = getUpdatedBoat();
        assertThrows(NotFoundException.class, () -> service.update(updated, USER_ID));
    }

    @Test
    public void deleteAdmin() {
        service.delete(BOAT_ID_1, ADMIN_ID);
        assertThrows(NotFoundException.class, () -> service.get(BOAT_ID_1));
    }

    @Test
    public void deleteModerator() {
        service.delete(BOAT_ID_1, MODERATOR_ID);
        assertThrows(NotFoundException.class, () -> service.get(BOAT_ID_1));
    }


    @Test
    public void deleteUser() {
        assertThrows(NotFoundException.class, () -> service.delete(BOAT_ID_1, USER_ID));
    }

    @Test
    public void deleteNotFound() {
        assertThrows(NotFoundException.class, () -> service.delete(NOT_FOUND, ADMIN_ID));
    }

    @Test
    public void get() {
        Boat boat = service.get(BOAT_ID_1);
        BOAT_MATCHER.assertMatch(boat, BOAT_1);
    }

    @Test
    public void getNotFound() {
        assertThrows(NotFoundException.class, () -> service.get(NOT_FOUND));
    }

    @Test
    public void getAll() {
        BOAT_MATCHER.assertMatch(service.getAll(), getAllBoat());
    }
}