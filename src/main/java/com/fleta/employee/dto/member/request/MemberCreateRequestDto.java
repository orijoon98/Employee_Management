package com.fleta.employee.dto.member.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

@Getter
public class MemberCreateRequestDto {
    @Schema(description = "아이디", example = "loginId1234")
    private final String loginId;
    @Schema(description = "비밀번호", example = "password1234")
    private final String password;
    @Schema(description = "등급", example = "사용자")
    private final String role;

    @Builder
    public MemberCreateRequestDto(String loginId, String password, String role) {
        this.loginId = loginId;
        this.password = password;
        this.role = role;
    }
}
