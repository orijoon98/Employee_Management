package com.fleta.employee.dto.user.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class UserPublicReqDto {
    private String country;
    private LocalDate birthday;
    private String gender;
    private String zipCode;
    private String address;
    private String detailAddress;
    private String number;
    private String phoneNumber;

    @Builder
    public UserPublicReqDto(String country, LocalDate birthday, String gender, String zipCode, String address, String detailAddress, String number, String phoneNumber) {
        this.country = country;
        this.birthday = birthday;
        this.gender = gender;
        this.zipCode = zipCode;
        this.address = address;
        this.detailAddress = detailAddress;
        this.number = number;
        this.phoneNumber = phoneNumber;
    }
}
