package com.fleta.employee.model.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class Employee {
    private String id;
    private String password;
    private String picture;
    private String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date joinDate;
    private String country;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    private String gender;
    private String zipCode;
    private String address;
    private String addressDetail;
    private String number;
    private String phoneNumber;
    private String email;
    private String department;
    private String rank;
    private String occupation;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date leaveDate;
    private String bank;
    private String bankNumber;
    private String bankName;
    private String note;
    private String grade;
}
