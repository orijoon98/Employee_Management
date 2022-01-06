package com.fleta.employee.repository;

import com.fleta.employee.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    User save(User user);
    Optional<User> findByLoginId(String loginId);
    Optional<User> findByEmail(String email);
    void delete(User user);
}
