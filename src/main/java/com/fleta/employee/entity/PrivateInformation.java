package com.fleta.employee.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PrivateInformation extends BaseEntity {

    private String bank;

    private String accountNumber;

    private String accountHolder;

    private String note;

    @Builder
    public PrivateInformation(String bank, String accountNumber, String accountHolder, String note) {
        this.bank = bank;
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.note = note;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }
}
