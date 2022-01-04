package com.fleta.employee.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Auth extends Base {
    @Column(nullable = false, unique = true)
    private String 사번;

    @JsonIgnore
    @Column(nullable = false)
    private String 비밀번호;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Role 등급;

    @Builder
    public Auth(String 사번, String 비밀번호, Role 등급) {
        this.사번 = 사번;
        this.비밀번호 = 비밀번호;
        this.등급 = 등급;
    }
}
