package com.fleta.employee.controller;

import com.fleta.employee.dto.ResponseDto;
import com.fleta.employee.dto.user.request.UserPrivateReqDto;
import com.fleta.employee.dto.user.request.UserPublicReqDto;
import com.fleta.employee.service.UserService;
import com.fleta.employee.util.CookieUtil;
import com.fleta.employee.util.JwtUtil;
import com.fleta.employee.util.RequestUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
@ControllerAdvice
public class UserController {
    private final UserService userService;
    private final CookieUtil cookieUtil;

    @PutMapping("/public")
    public ResponseEntity updateUserPublic(@RequestBody UserPublicReqDto userPublicReqDto, HttpServletRequest request) {
        RequestUtil.checkNeedValue(
                userPublicReqDto.getCountry(),
                userPublicReqDto.getBirthday(),
                userPublicReqDto.getGender(),
                userPublicReqDto.getZipCode(),
                userPublicReqDto.getAddress(),
                userPublicReqDto.getDetailAddress(),
                userPublicReqDto.getNumber(),
                userPublicReqDto.getPhoneNumber()
        );

        Cookie token = cookieUtil.getCookie(request, JwtUtil.ACCESS_TOKEN_NAME);
        String tokenValue = token.getValue();

        userService.updateUserPublic(
                tokenValue,
                userPublicReqDto.getCountry(),
                userPublicReqDto.getBirthday(),
                userPublicReqDto.getGender(),
                userPublicReqDto.getZipCode(),
                userPublicReqDto.getAddress(),
                userPublicReqDto.getDetailAddress(),
                userPublicReqDto.getNumber(),
                userPublicReqDto.getPhoneNumber()
        );

        return ResponseEntity.status(200).body(
                ResponseDto.builder()
                        .status(200)
                        .message("User: Public Information 수정 성공")
                        .data(null)
                        .build()
        );
    }

    @PutMapping("/private")
    public ResponseEntity updateUserPrivate(@RequestBody UserPrivateReqDto userPrivateReqDto, HttpServletRequest request) {
        RequestUtil.checkNeedValue(
                userPrivateReqDto.getBank(),
                userPrivateReqDto.getAccountNumber(),
                userPrivateReqDto.getAccountHolder(),
                userPrivateReqDto.getNote()
        );

        Cookie token = cookieUtil.getCookie(request, JwtUtil.ACCESS_TOKEN_NAME);
        String tokenValue = token.getValue();

        userService.updateUserPrivate(
                tokenValue,
                userPrivateReqDto.getBank(),
                userPrivateReqDto.getAccountNumber(),
                userPrivateReqDto.getAccountHolder(),
                userPrivateReqDto.getNote()
        );

        return ResponseEntity.status(200).body(
                ResponseDto.builder()
                        .status(200)
                        .message("User: Private Information 수정 성공")
                        .data(null)
                        .build()
        );
    }
}
