package com.fleta.employee.dto.auth.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SignupReqDto {
    private String loginId;
    private String password;
    private String name;
    private String email;

    @Builder
    public SignupReqDto(String loginId, String password, String name, String email) {
        this.loginId = loginId;
        this.password = password;
        this.name = name;
        this.email = email;
    }
}
