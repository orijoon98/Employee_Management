package com.fleta.employee.dto.member;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class NonMemberRequestDto {
    private String loginId;
    private String password;
    private String name;
    private String email;

    @Builder
    public NonMemberRequestDto(String loginId, String password, String name, String email) {
        this.loginId = loginId;
        this.password = password;
        this.name = name;
        this.email = email;
    }
}
