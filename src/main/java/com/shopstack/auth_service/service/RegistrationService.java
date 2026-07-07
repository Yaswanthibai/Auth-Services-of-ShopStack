package com.shopstack.auth_service.service;

import com.shopstack.auth_service.dto.CustomerRegisterRequest;
import com.shopstack.auth_service.dto.VendorRegisterRequest;
import org.springframework.web.multipart.MultipartFile;

public interface RegistrationService {

    String registerCustomer(
            CustomerRegisterRequest request);

    String registerVendor(
            VendorRegisterRequest request,
            MultipartFile businessLicenseDocument,
            MultipartFile gstDocument,
            MultipartFile panDocument
    );
}