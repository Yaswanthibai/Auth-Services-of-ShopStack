package com.shopstack.auth_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/vendor")
public class VendorController {

    @GetMapping("/profile")
    public String getVendorProfile() {

        return "Vendor Profile Access Granted";
    }

    @GetMapping("/dashboard")
    public String vendorDashboard() {

        return "Vendor Dashboard";
    }
}