package com.fleta.employee.service;

import com.fleta.employee.domain.Auth;
import com.fleta.employee.domain.Role;
import com.fleta.employee.repository.AuthRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class AuthService {
    private final AuthRepository authRepository;

    public Auth createAuth(String 사번) {
        Auth auth = Auth.builder()
                .사번(사번)
                .비밀번호("0000")
                .등급(Role.사용자)
                .build();

        return authRepository.save(auth);
    }
}
