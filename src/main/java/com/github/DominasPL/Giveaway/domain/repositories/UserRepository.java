package com.github.DominasPL.Giveaway.domain.repositories;

import com.github.DominasPL.Giveaway.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    @Query(value = "SELECT * FROM users \n" +
            "JOIN users_roles ON users.id=users_roles.user_id\n" +
            "WHERE role_id = 2;", nativeQuery = true)
    List<User> findAllAdmins();

    @Query(value = "SELECT * FROM users \n" +
            "JOIN users_roles ON users.id=users_roles.user_id\n" +
            "WHERE role_id = 1;", nativeQuery = true)
    List<User> findAllUsers();
}
