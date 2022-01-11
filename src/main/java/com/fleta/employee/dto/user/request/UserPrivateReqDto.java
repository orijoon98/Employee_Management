package com.fleta.employee.dto.user.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserPrivateReqDto {
    private String bank;
    private String accountNumber;
    private String accountHolder;
    private String note;

    @Builder
    public UserPrivateReqDto(String bank, String accountNumber, String accountHolder, String note) {
        this.bank = bank;
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.note = note;
    }
}
