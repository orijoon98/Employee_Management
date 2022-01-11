package com.fleta.employee.service;

import com.fleta.employee.entity.PrivateInformation;
import com.fleta.employee.entity.PublicInformation;
import com.fleta.employee.entity.User;
import com.fleta.employee.enums.Authority;
import com.fleta.employee.exception.*;
import com.fleta.employee.repository.PrivateInformationRepository;
import com.fleta.employee.repository.PublicInformationRepository;
import com.fleta.employee.repository.UserRepository;
import com.fleta.employee.util.EmailUtil;
import com.fleta.employee.util.RedisUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class AuthService {
    private final UserRepository userRepository;
    private final PublicInformationRepository publicInformationRepository;
    private final PrivateInformationRepository privateInformationRepository;
    private final PasswordEncoder passwordEncoder;
    private final RedisUtil redisUtil;
    private final EmailUtil emailUtil;

    public User signup(String loginId, String password, String name, String email) {
        checkDuplicateMember(loginId);
        checkDuplicateEmail(email);
        checkValidPassword(password);

        PublicInformation publicInformation = PublicInformation.builder()
                .build();

        PrivateInformation privateInformation = PrivateInformation.builder()
                .build();

        publicInformationRepository.save(publicInformation);
        privateInformationRepository.save(privateInformation);

        User user = User.builder()
                .loginId(loginId)
                .password(passwordEncoder.encode(password))
                .name(name)
                .email(email)
                .authority(Authority.ROLE_NOT_PERMITTED)
                .publicInformation(publicInformation)
                .privateInformation(privateInformation)
                .build();

        return userRepository.save(user);
    }

    public User login(String loginId, String password) {
        Optional<User> member = userRepository.findByLoginId(loginId);
        if(member.isEmpty()) throw new NotExistLoginIdException();
        member.ifPresent(m -> {
            if(!(passwordEncoder.matches(password, m.getPassword())
            || password.equals(m.getPassword())))
                throw new InvalidPasswordException();
        });

        return member.get();
    }

    public void delete(String loginId) {
        Optional<User> user = userRepository.findByLoginId(loginId);
        PublicInformation publicInformation = user.get().getPublicInformation();
        PrivateInformation privateInformation = user.get().getPrivateInformation();
        userRepository.delete(user.get());
        publicInformationRepository.delete(publicInformation);
        privateInformationRepository.delete(privateInformation);
    }

    public void sendVerificationMail(User user) {
        String VERIFICATION_LINK = "http://localhost:8080/auth/verify/";
        UUID uuid = UUID.randomUUID();
        redisUtil.setDataExpire(uuid.toString(), user.getLoginId(), 1000L * 60 * 3); // 3분
        emailUtil.sendMail(user.getEmail(), "회원가입 인증메일입니다.", VERIFICATION_LINK + uuid.toString());
    }

    public void verifyEmail(String key) {
        String loginId = redisUtil.getData(key);
        Optional<User> user = userRepository.findByLoginId(loginId);
        modifyUserRole(user.get(), Authority.ROLE_USER);
        redisUtil.deleteData(key);
    }

    public User findByLoginId(String loginId) {
        Optional<User> user = userRepository.findByLoginId(loginId);
        return user.get();
    }

    public void modifyUserRole(User user, Authority authority) {
        user.setAuthority(authority);
        user.setUpdatedAt(LocalDateTime.now());
        userRepository.save(user);
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
