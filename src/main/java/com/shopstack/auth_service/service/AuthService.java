package com.shopstack.auth_service.service;

import com.shopstack.auth_service.dto.LoginRequest;
import com.shopstack.auth_service.dto.LoginResponse;

public interface AuthService {

    LoginResponse login(LoginRequest request);
}