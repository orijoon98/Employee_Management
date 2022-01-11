package com.fleta.employee.entity;

import lombok.*;

import javax.persistence.Entity;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PublicInformation extends BaseEntity {
    private String country;

    private LocalDate birthday;

    private String gender;

    private String zipCode;

    private String address;

    private String detailAddress;

    private String number;

    private String phoneNumber;

    private String department;

    private String position;

    private String occupation;

    private LocalDate joinedAt;

    private LocalDate resignedAt;

    @Builder
    public PublicInformation(String country, LocalDate birthday, String gender, String zipCode, String address, String detailAddress, String number, String phoneNumber, String department, String position, String occupation, LocalDate joinedAt, LocalDate resignedAt) {
        this.country = country;
        this.birthday = birthday;
        this.gender = gender;
        this.zipCode = zipCode;
        this.address = address;
        this.detailAddress = detailAddress;
        this.number = number;
        this.phoneNumber = phoneNumber;
        this.department = department;
        this.position = position;
        this.occupation = occupation;
        this.joinedAt = joinedAt;
        this.resignedAt = resignedAt;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }
}
