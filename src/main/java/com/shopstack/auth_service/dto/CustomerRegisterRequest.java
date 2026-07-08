package com.shopstack.auth_service.dto;

import lombok.Data;

@Data
public class CustomerRegisterRequest {

    private String fullName;
    private String email;
    private String password;
    private String phone;

    private String gender;

}