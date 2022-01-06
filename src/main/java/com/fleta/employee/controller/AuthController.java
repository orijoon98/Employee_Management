package com.fleta.employee.controller;

import com.fleta.employee.dto.LoginDto;
import com.fleta.employee.dto.SignupDto;
import com.fleta.employee.entity.User;
import com.fleta.employee.service.AuthService;
import com.fleta.employee.util.CookieUtil;
import com.fleta.employee.util.JwtUtil;
import com.fleta.employee.util.RedisUtil;
import com.fleta.employee.util.RequestUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
@ControllerAdvice
@Slf4j
public class AuthController {
    private final AuthService authService;
    private final JwtUtil jwtUtil;
    private final CookieUtil cookieUtil;
    private final RedisUtil redisUtil;

    @PostMapping("/signup")
    public ResponseEntity signup(@RequestBody SignupDto signupDto) {
        RequestUtil.checkNeedValue(
                signupDto.getLoginId(),
                signupDto.getPassword(),
                signupDto.getName(),
                signupDto.getEmail()
        );

        final User user = authService.signup(signupDto.getLoginId(), signupDto.getPassword(), signupDto.getName(), signupDto.getEmail());

        return ResponseEntity.status(200).body(user);
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginDto loginDto, HttpServletRequest req, HttpServletResponse res) {
        RequestUtil.checkNeedValue(
            loginDto.getLoginId(),
            loginDto.getPassword()
        );

        final User user = authService.login(loginDto.getLoginId(), loginDto.getPassword());
        final String token = jwtUtil.generateToken(user);
        final String refreshJwt = jwtUtil.generateRefreshToken(user);
        Cookie accessToken = cookieUtil.createCookie(JwtUtil.ACCESS_TOKEN_NAME, token);
        Cookie refreshToken = cookieUtil.createCookie(JwtUtil.REFRESH_TOKEN_NAME, refreshJwt);
        redisUtil.setDataExpire(refreshJwt, user.getLoginId(), JwtUtil.REFRESH_TOKEN_VALIDATION_SECOND);
        res.addCookie(accessToken);
        res.addCookie(refreshToken);

        return ResponseEntity.status(200).body(token);
    }
}
