package com.shopstack.auth_service.dto;

import lombok.Data;

@Data
public class VendorRegisterRequest {

    // User Details
    private String fullName;
    private String email;
    private String password;
    private String phone;

    // Business Details
    private String businessName;
    private String businessRegistrationNumber;
    private String gstNumber;
    private String panNumber;

    // Business Contact
    private String businessEmail;
    private String businessPhone;

    // Address
    private String address;
    private String city;
    private String state;
    private String pincode;

    // Bank Details
    private String bankAccountNumber;
    private String ifscCode;
    private String accountHolderName;
}