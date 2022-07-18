package com.aleksi;

import com.aleksi.model.user.Role;
import com.aleksi.model.user.User;

import java.util.Collections;
import java.util.Date;

import static com.aleksi.model.AbstractBaseEntity.START_SEQ;

public class UserTestData {
    public static final MatcherFactory.Matcher<User> USER_MATCHER = MatcherFactory
            .usingIgnoringFieldsComparator("registered");

    public static final int USER_ID = START_SEQ;
    public static final int ADMIN_ID = START_SEQ + 1;
    public static final int MODERATOR_ID = START_SEQ + 2;
    public static final int NOT_FOUND = 10;

    public static final User user = new User(USER_ID, "User", "user@yandex.ru", "password", Role.USER);
    public static final User admin = new User(ADMIN_ID, "Admin", "admin@gmail.com", "admin", Role.ADMIN);
    public static final User moder = new User(MODERATOR_ID, "Moderator", "moder@gmail.com", "moder", Role.MODERATOR);

    public static User getNew() {
        return new User(null, "New", "new@gmail.com", "newPass", new Date(),
                Collections.singleton(Role.USER));
    }

    public static User getUpdated() {
        User updated = new User(user);
        updated.setEmail("update@gmail.com");
        updated.setName("UpdatedName");
        updated.setPassword("newPass");
        updated.setRoles(Collections.singletonList(Role.ADMIN));
        return updated;
    }
}