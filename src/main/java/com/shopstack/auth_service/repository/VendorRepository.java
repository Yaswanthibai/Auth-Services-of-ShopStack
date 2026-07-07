package com.shopstack.auth_service.repository;

import com.shopstack.auth_service.entity.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendorRepository
        extends JpaRepository<Vendor, Long> {
}