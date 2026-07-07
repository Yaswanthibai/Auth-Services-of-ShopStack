package com.shopstack.auth_service.serviceimpl;

import com.shopstack.auth_service.dto.LoginRequest;
import com.shopstack.auth_service.dto.LoginResponse;
import com.shopstack.auth_service.repository.UserRepository;
import com.shopstack.auth_service.security.JwtService;
import com.shopstack.auth_service.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Service;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import com.shopstack.auth_service.entity.User;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl
        implements AuthService {

    private final AuthenticationManager
            authenticationManager;

    private final JwtService
            jwtService;

    private final UserRepository userRepository;

    @Override
    public LoginResponse login(LoginRequest request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        String token = jwtService.generateToken(user.getEmail());

        return new LoginResponse(token);
    }
}