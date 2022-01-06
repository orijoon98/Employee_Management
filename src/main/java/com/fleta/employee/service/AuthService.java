package com.fleta.employee.service;

import com.fleta.employee.entity.User;
import com.fleta.employee.enums.Authority;
import com.fleta.employee.exception.*;
import com.fleta.employee.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User signup(String loginId, String password, String name, String email) {
        checkDuplicateMember(loginId);
        checkDuplicateEmail(email);
        checkValidPassword(password);

        User user = User.builder()
                .loginId(loginId)
                .password(passwordEncoder.encode(password))
                .name(name)
                .email(email)
                .authority(Authority.ROLE_NOT_PERMITTED)
                .build();

        return userRepository.save(user);
    }

    public User login(String loginId, String password) {
        Optional<User> member = userRepository.findByLoginId(loginId);
        if(member.isEmpty()) throw new NotExistLoginIdException();
        member.ifPresent(m -> {
            if(!passwordEncoder.matches(password, m.getPassword()))
                throw new InvalidPasswordException();
        });
        return member.get();
    }

    private void checkDuplicateMember(String loginId) {
        userRepository.findByLoginId(loginId).ifPresent(m -> {
            throw new DuplicateMemberException();
        });
    }

    private void checkDuplicateEmail(String email) {
        userRepository.findByEmail(email).ifPresent(m -> {
            throw new DuplicateEmailException();
        });
    }

    private void checkValidPassword(String password) {
        int min = 8;
        int max = 20;
        // 영어, 숫자, 특수문자 포함 min~max글자
        final String regex = "^((?=.*\\d)(?=.*[a-zA-Z])(?=.*[\\W]).{" + min + "," + max + "})$";
        // 공백 문자 정규식
        final String blankRegex = "(\\s)";

        Matcher matcher;

        // 공백 체크
        matcher = Pattern.compile(blankRegex).matcher(password);
        if (matcher.find()) {
            throw new InvalidBlankPasswordException();
        }

        // 정규식 체크
        matcher = Pattern.compile(regex).matcher(password);
        if (!matcher.find()) {
            throw new InvalidRegexPasswordException();
        }
    }
}
