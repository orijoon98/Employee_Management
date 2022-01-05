package com.fleta.employee.controller;

import com.fleta.employee.domain.Member;
import com.fleta.employee.dto.Message;
import com.fleta.employee.dto.Status;
import com.fleta.employee.dto.member.request.NonMemberRequestDto;
import com.fleta.employee.exception.NotExistRequestValueException;
import com.fleta.employee.service.AuthService;
import com.fleta.employee.util.RequestUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class AuthController {
    private final AuthService authService;

    @PostMapping("/none/create")
    public ResponseEntity<Message> signUpNonMember(@RequestBody NonMemberRequestDto nonMemberRequestDto) {
        try {
            RequestUtil.checkNeedValue(
                    nonMemberRequestDto.getLoginId(),
                    nonMemberRequestDto.getPassword(),
                    nonMemberRequestDto.getName(),
                    nonMemberRequestDto.getEmail()
            );
        } catch (NotExistRequestValueException e) {
            return new ResponseEntity<>(new Message(Status.BAD_REQUEST, "잘못된 요청입니다.", null), new HttpHeaders(), 400);
        }

        Member nonMember = authService.signUpNonMember(nonMemberRequestDto.getLoginId(), nonMemberRequestDto.getPassword(), nonMemberRequestDto.getName(), nonMemberRequestDto.getEmail());

        return new ResponseEntity<>(new Message(Status.OK, "성공입니다.", nonMember), new HttpHeaders(), 200);
    }
}
