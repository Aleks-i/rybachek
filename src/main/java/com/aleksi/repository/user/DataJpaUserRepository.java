package com.aleksi.repository.user;

import com.aleksi.model.user.Role;
import com.aleksi.model.user.User;
import com.aleksi.util.exception.NotFoundException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DataJpaUserRepository implements UserRepository {
    private static final Sort SORT_NAME_EMAIL = Sort.by(Sort.Direction.ASC, "name", "email");

    private final CrudUserRepository crudRepository;

    public DataJpaUserRepository(CrudUserRepository crudRepository) {
        this.crudRepository = crudRepository;
    }

    @Override
    public User save(User user) {
        return crudRepository.save(user);
    }

    @Override
    public boolean delete(int id) {
        return crudRepository.delete(id) != 0;
    }

    @Override
    public User get(int id) {
        return crudRepository.findById(id).orElse(null);
    }

    @Override
    public User getByEmail(String email) {
        return crudRepository.getByEmail(email);
    }

    @Override
    public List<User> getAll() {
        return crudRepository.findAll(SORT_NAME_EMAIL);
    }

    protected boolean checkRoleAdminModerator(int userId) {
        User user = crudRepository.findById(userId).orElse(null);
        if (user == null || !user.getRoles().contains(Role.ADMIN) || !user.getRoles().contains(Role.MODERATOR)) {
            throw new NotFoundException("User not exist or there is no privilege for the operation");
        }
        return true;
    }
}