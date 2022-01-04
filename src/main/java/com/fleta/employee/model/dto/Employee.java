package com.fleta.employee.model.dto;

import lombok.Data;

import java.util.Date;

@Data
public class Employee {

    private String 사번;
    private String 비밀번호;
    private String 사진;
    private String 이름;
    private Date 입사년월일;
    private String 국적;
    private Date 생년월일;
    private String 성별;
    private String 우편번호;
    private String 주소;
    private String 상세주소;
    private String 전화번호;
    private String 휴대폰번호;
    private String 이메일;
    private String 부서;
    private String 직급;
    private String 직종;
    private Date 퇴사년월일;
    private String 급여이체은행;
    private String 계좌번호;
    private String 예금주;
    private String 비고;
    private String 등급;
}

