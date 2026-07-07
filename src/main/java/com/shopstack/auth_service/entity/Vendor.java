package com.shopstack.auth_service.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="vendors")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Vendor {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long vendorId;

    @OneToOne
    @JoinColumn(name="user_id")
    private User user;

    private String businessName;

    private String businessEmail;

    private String businessPhone;

    private String address;

    private String city;

    private String state;

    private String pincode;

    // Business Verification
    private String businessRegistrationNumber;

    private String gstNumber;

    private String panNumber;

    // Bank Details
    private String bankAccountNumber;

    private String ifscCode;

    private String accountHolderName;

    // Documents
    private String businessLicenseDocument;

    private String gstDocument;

    private String panDocument;

    // Approval Status
    @Enumerated(EnumType.STRING)
    private VendorStatus status =
            VendorStatus.PENDING;

    // Admin Comments
    private String adminRemarks;
}