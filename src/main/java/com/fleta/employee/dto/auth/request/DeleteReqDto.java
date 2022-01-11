package com.fleta.employee.dto.auth.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class DeleteReqDto {
    private String loginId;

    @Builder
    public DeleteReqDto(String loginId) {
        this.loginId = loginId;
    }
}
