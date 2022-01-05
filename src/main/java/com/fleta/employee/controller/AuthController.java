package com.fleta.employee.controller;

import com.fleta.employee.dto.error.ServerErrorFailResponseDto;
import com.fleta.employee.service.AuthService;
import com.fleta.employee.util.RequestUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
//    private final AuthService authService;

//    @ApiResponses({
//            @ApiResponse(responseCode = "200", description = "회원 가입 성공", content = @Content(schema = @Schema(implementation = AuthCreateResponseDto.class))),
//            @ApiResponse(responseCode = "500", description = "* 서버 에러", content = @Content(schema = @Schema(implementation = ServerErrorFailResponseDto.class)))
//    })
//    @Operation(summary = "가입", description = "회원 가입")
//    @PostMapping("/create")
//    public ResponseEntity<?> createAuth(@RequestBody AuthCreateRequestDto authCreateRequestDto) {
//        RequestUtil.checkNeedValue(
//                authCreateRequestDto.get사번(),
//                authCreateRequestDto.get비밀번호(),
//                authCreateRequestDto.get등급()
//        );
//
//        Auth auth = authService.createAuth(authCreateRequestDto.get사번());
//
//        BaseResponseSuccessDto responseBody = new AuthCreateResponseDto(auth);
//        return ResponseEntity.ok(responseBody);
//
//    }
}
