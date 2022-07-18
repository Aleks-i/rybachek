package com.aleksi.service;

import com.aleksi.model.user.User;
import com.aleksi.repository.user.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

import static com.aleksi.util.ValidationUtil.checkNotFound;
import static com.aleksi.util.ValidationUtil.checkNotFoundWithId;

@Service
public class UserService {
    protected final Logger log = LoggerFactory.getLogger(getClass());

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User create(User user) {
        log.info("create user {}", user);
        Assert.notNull(user, "user must not be null");
        return repository.save(user);
    }

    public void delete(int id) {
        log.info("delete user id {}", id);
        checkNotFoundWithId(repository.delete(id), id);
    }

    public User get(int id) {
        log.info("get user id {}", id);
        return checkNotFoundWithId(repository.get(id), id);
    }

    public User getByEmail(String email) {
        log.info("get user by email {}", email);
        Assert.notNull(email, "email must not be null");
        return checkNotFound(repository.getByEmail(email), "email=" + email);
    }

    public List<User> getAll() {
        log.info("get all user");
        return repository.getAll();
    }

    public void update(User user) {
        log.info("update user {}", user);
        Assert.notNull(user, "user must not be null");
        checkNotFoundWithId(repository.save(user), user.id());
    }
}