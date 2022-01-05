package com.fleta.employee.controller;

import com.fleta.employee.domain.Member;
import com.fleta.employee.dto.member.NonMemberRequestDto;
import com.fleta.employee.service.AuthService;
import com.fleta.employee.util.RequestUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@ControllerAdvice
@Slf4j
public class AuthController {
    private final AuthService authService;

    @PostMapping("/none/create")
    public ResponseEntity signUpNonMember(@RequestBody NonMemberRequestDto nonMemberRequestDto)
    {
        RequestUtil.checkNeedValue(
                nonMemberRequestDto.getLoginId(),
                nonMemberRequestDto.getPassword(),
                nonMemberRequestDto.getName(),
                nonMemberRequestDto.getEmail()
        );

        Member nonMember = authService.signUpNonMember(nonMemberRequestDto.getLoginId(), nonMemberRequestDto.getPassword(), nonMemberRequestDto.getName(), nonMemberRequestDto.getEmail());

        return ResponseEntity.status(200).body(nonMember);
    }
}
