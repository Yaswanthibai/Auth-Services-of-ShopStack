package com.shopstack.auth_service.controller;

import com.shopstack.auth_service.dto.CustomerRegisterRequest;
import com.shopstack.auth_service.dto.VendorRegisterRequest;
import com.shopstack.auth_service.service.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;

    // Customer Registration
    @PostMapping("/customer/register")
    public String registerCustomer(
            @RequestBody CustomerRegisterRequest request) {

        return registrationService.registerCustomer(request);
    }

    // Vendor Registration
    @PostMapping(
            value = "/vendor/register",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE
    )
    public String registerVendor(

            @ModelAttribute VendorRegisterRequest request,

            @RequestParam("businessLicenseDocument")
            MultipartFile businessLicenseDocument,

            @RequestParam("gstDocument")
            MultipartFile gstDocument,

            @RequestParam("panDocument")
            MultipartFile panDocument
    ) {

        return registrationService.registerVendor(
                request,
                businessLicenseDocument,
                gstDocument,
                panDocument
        );
    }
}