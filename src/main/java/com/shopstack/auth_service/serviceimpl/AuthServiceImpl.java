package com.shopstack.auth_service.serviceimpl;

import com.shopstack.auth_service.dto.LoginRequest;
import com.shopstack.auth_service.dto.LoginResponse;
import com.shopstack.auth_service.security.JwtService;
import com.shopstack.auth_service.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl
        implements AuthService {

    private final AuthenticationManager
            authenticationManager;

    private final JwtService
            jwtService;

    @Override
    public LoginResponse login(
            LoginRequest request) {

        return null;
    }
}