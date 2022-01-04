package com.fleta.employee.repository;

import com.fleta.employee.domain.Auth;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaAuthRepository extends JpaRepository<Auth, Long>, AuthRepository {
}
