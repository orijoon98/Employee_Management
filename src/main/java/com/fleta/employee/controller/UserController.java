package com.fleta.employee.controller;

import com.fleta.employee.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
@ControllerAdvice
public class UserController {
    private final UserService userService;

    @GetMapping("/test")
    public String test(){
        return "test";
    }
}
