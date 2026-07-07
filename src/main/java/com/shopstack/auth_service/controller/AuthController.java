package com.shopstack.auth_service.controller;

import com.shopstack.auth_service.dto.LoginRequest;
import com.shopstack.auth_service.dto.LoginResponse;
import com.shopstack.auth_service.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public LoginResponse login(
            @RequestBody LoginRequest request) {

        return authService.login(request);
    }
}