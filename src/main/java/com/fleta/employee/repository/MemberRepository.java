package com.fleta.employee.repository;

import com.fleta.employee.domain.Member;

import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);

    Optional<Member> findByLoginId(String loginId);

    void delete(Member member);
}
