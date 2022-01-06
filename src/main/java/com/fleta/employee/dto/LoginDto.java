package com.fleta.employee.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LoginDto {
    private String loginId;
    private String password;

    @Builder
    public LoginDto(String loginId, String password) {
        this.loginId = loginId;
        this.password = password;
    }
}
