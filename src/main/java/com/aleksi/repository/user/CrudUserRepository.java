package com.aleksi.repository.user;

import com.aleksi.model.user.Role;
import com.aleksi.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Transactional(readOnly = true)
public interface CrudUserRepository extends JpaRepository<User, Integer> {
    @Transactional
    @Modifying
    @Query("DELETE FROM User u WHERE u.id=:id")
    int delete(@Param("id") int id);

    User getByEmail(String email);

    default boolean checkRoleAdminOrModerator(int userId) {
        User user = findById(userId).orElse(null);
        if (user == null) {
            return false;
        }
        Set<Role> roleSet = user.getRoles();
        return roleSet.contains(Role.ADMIN) || roleSet.contains(Role.MODERATOR);
    }
}