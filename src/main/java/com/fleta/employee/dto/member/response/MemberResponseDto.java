package com.fleta.employee.dto.member.response;

import com.fleta.employee.domain.Member;
import com.fleta.employee.dto.BaseResponseSuccessDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Getter
public class MemberResponseDto extends BaseResponseSuccessDto {
    @Schema(description = "생성된 회원")
    private final Member response;

    public MemberResponseDto(Member response) {
        this.response = response;
    }
}
