package com.fleta.employee.dto.member.request;

import lombok.Builder;
import lombok.Getter;

@Getter
public class NonMemberRequestDto {
    private String loginId;
    private String password;
    private String name;
    private String email;

    public NonMemberRequestDto() {
    }

    @Builder
    public NonMemberRequestDto(String loginId, String password, String name, String email) {
        this.loginId = loginId;
        this.password = password;
        this.name = name;
        this.email = email;
    }
}
