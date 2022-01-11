package com.fleta.employee.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fleta.employee.enums.Authority;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseEntity {
    @Column(name = "login_id", nullable = false, unique = true)
    private String loginId;

    @JsonIgnore
    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Setter
    @Enumerated(value = EnumType.STRING)
    @Column(name = "authority", nullable = false)
    private Authority authority;

    @OneToOne
    @JoinColumn(name = "id")
    private PublicInformation publicInformation;

    @OneToOne
    @JoinColumn(name = "id")
    private PrivateInformation privateInformation;

    @Builder
    public User(String loginId, String password, String name, String email, Authority authority, PublicInformation publicInformation, PrivateInformation privateInformation) {
        this.loginId = loginId;
        this.password = password;
        this.name = name;
        this.email = email;
        this.authority = authority;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        this.publicInformation = publicInformation;
        this.privateInformation = privateInformation;
    }
}
