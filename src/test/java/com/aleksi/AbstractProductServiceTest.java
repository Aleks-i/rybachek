package com.aleksi;

import com.aleksi.model.product.AbstractProductEntity;
import com.aleksi.service.product.ProductService;
import com.aleksi.util.exception.NotFoundException;
import org.junit.Test;

import static com.aleksi.UserTestData.*;
import static org.junit.Assert.assertThrows;

public abstract class AbstractProductServiceTest<T extends AbstractProductEntity> extends AbstractServiceTest {

    protected ProductService<T> service;
    protected TestData<T> testData;

    @Test
    public void createAdmin() {
        MatcherFactory.Matcher<T> MATCHER = testData.getMatcher();
        T created = service.create(testData.getNew(), ADMIN_ID);
        int newId = created.id();
        T newEntity = testData.getNew();
        newEntity.setId(newId);
        MATCHER.assertMatch(created, newEntity);
        MATCHER.assertMatch(service.get(newId), newEntity);
    }

    @Test
    public void createModerator() {
        MatcherFactory.Matcher<T> MATCHER = testData.getMatcher();
        T created = service.create(testData.getNew(), MODERATOR_ID);
        int newId = created.id();
        T newEntity = testData.getNew();
        newEntity.setId(newId);
        MATCHER.assertMatch(created, newEntity);
        MATCHER.assertMatch(service.get(newId), newEntity);
    }

    @Test
    public void createWithUserId() {
        assertThrows(NotFoundException.class, () -> service.create(testData.getNew(), USER_ID));
    }

    @Test
    public void updateAdmin() {
        MatcherFactory.Matcher<T> MATCHER = testData.getMatcher();
        T updated = testData.getUpdated();
        service.update(updated, ADMIN_ID);
        MATCHER.assertMatch(service.get(testData.getEntityIdOne()), testData.getUpdated());
    }

    @Test
    public void updateModerator() {
        MatcherFactory.Matcher<T> MATCHER = testData.getMatcher();
        T updated = testData.getUpdated();
        service.update(updated, MODERATOR_ID);
        MATCHER.assertMatch(service.get(testData.getEntityIdOne()), testData.getUpdated());
    }

    @Test
    public void updateUser() {
        T updated = testData.getUpdated();
        assertThrows(NotFoundException.class, () -> service.update(updated, USER_ID));
    }

    @Test
    public void deleteAdmin() {
        service.delete(testData.getEntityIdOne(), ADMIN_ID);
        assertThrows(NotFoundException.class, () -> service.get(testData.getEntityIdOne()));
    }

    @Test
    public void deleteModerator() {
        service.delete(testData.getEntityIdOne(), MODERATOR_ID);
        assertThrows(NotFoundException.class, () -> service.get(testData.getEntityIdOne()));
    }


    @Test
    public void deleteUser() {
        MatcherFactory.Matcher<T> MATCHER = testData.getMatcher();
        assertThrows(NotFoundException.class, () -> service.delete(testData.getEntityIdOne(), USER_ID));
        MATCHER.assertMatch(service.get(testData.getEntityIdOne()), testData.getEntityOne());
    }

    @Test
    public void deleteNotFound() {
        assertThrows(NotFoundException.class, () -> service.delete(testData.getEntityIdNotFound(), ADMIN_ID));
    }

    @Test
    public void get() {
        MatcherFactory.Matcher<T> MATCHER = testData.getMatcher();
        T entity = service.get(testData.getEntityIdOne());
        MATCHER.assertMatch(entity, testData.getEntityOne());
    }

    @Test
    public void getNotFound() {
        assertThrows(NotFoundException.class, () -> service.get(testData.getEntityIdNotFound()));
    }

    @Test
    public void getAll() {
        MatcherFactory.Matcher<T> MATCHER = testData.getMatcher();
        MATCHER.assertMatch(service.getAll(), testData.getAll());
    }
}