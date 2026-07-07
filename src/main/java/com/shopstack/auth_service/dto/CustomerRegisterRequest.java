package com.shopstack.auth_service.dto;

import lombok.Data;

@Data
public class CustomerRegisterRequest {

    private String fullName;
    private String email;
    private String password;
    private String phone;

    private String gender;
    private String address;
    private String city;
    private String state;
    private String pincode;
}