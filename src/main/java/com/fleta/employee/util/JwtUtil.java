package com.fleta.employee.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JwtUtil {
    public static final String ACCESS_TOKEN_NAME = "accessToken";
    public static final String REFRESH_TOKEN_NAME = "refreshToken";
    private static final long ACCESS_TOKEN_EXPIRE_TIME = 1000 * 60 * 2 * 60; // 1시간
    private static final long REFRESH_TOKEN_EXPIRE_TIME = 1000L * 60 * 60 * 24; // 1일
    @Value("${jwt.secret}")
    private String SECRET_KEY;
}
