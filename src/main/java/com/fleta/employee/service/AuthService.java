package com.fleta.employee.service;

import com.fleta.employee.domain.Member;
import com.fleta.employee.domain.Role;
import com.fleta.employee.exception.DuplicateMemberException;
import com.fleta.employee.exception.InvalidBlankPasswordException;
import com.fleta.employee.exception.InvalidRegexPasswordException;
import com.fleta.employee.exception.NotExistMemberException;
import com.fleta.employee.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class AuthService {
    private final MemberRepository memberRepository;

    public Member signUpNonMember(String loginId, String password, String name, String email) {
        checkDuplicateMember(loginId);
        checkValidPassword(password);

        Member member = Member.builder()
                .loginId(loginId)
                .password(password)
                .name(name)
                .email(email)
                .role(Role.ROLE_NOT_PERMITTED)
                .build();

        System.out.println(member);
        return memberRepository.save(member);
    }

    public Member findMemberByLoginId(String loginId) {
        return memberRepository.findByLoginId(loginId).orElseThrow(NotExistMemberException::new);
    }

    private void checkDuplicateMember(String loginId) {
        memberRepository.findByLoginId(loginId).ifPresent(m -> {
            throw new DuplicateMemberException();
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
