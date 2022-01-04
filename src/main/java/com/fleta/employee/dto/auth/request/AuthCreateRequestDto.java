package com.fleta.employee.dto.auth.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

@Getter
public class AuthCreateRequestDto {
    @Schema(description = "사번", example = "123456")
    private final String 사번;
    @Schema(description = "비밀번호", example = "password1234")
    private final String 비밀번호;
    @Schema(description = "등급", example = "사용자")
    private final String 등급;

    @Builder
    public AuthCreateRequestDto(String 사번, String 비밀번호, String 등급) {
        this.사번 = 사번;
        this.비밀번호 = 비밀번호;
        this.등급 = 등급;
    }
}
