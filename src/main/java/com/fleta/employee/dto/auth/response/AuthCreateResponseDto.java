package com.fleta.employee.dto.auth.response;

import com.fleta.employee.domain.Auth;
import com.fleta.employee.dto.BaseResponseSuccessDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Getter
public class AuthCreateResponseDto extends BaseResponseSuccessDto {
    @Schema(description = "등록된 사원")
    private final Auth response;

    public AuthCreateResponseDto(Auth response) {
        this.response = response;
    }
}
