package com.fleta.employee.repository;

import com.fleta.employee.domain.Auth;

import java.util.Optional;

public interface AuthRepository {
    Auth save(Auth auth);

    Optional<Auth> findBy사번(String 사번);

    void delete(Auth auth);
}
