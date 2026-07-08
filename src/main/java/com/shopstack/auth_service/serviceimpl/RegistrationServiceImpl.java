package com.shopstack.auth_service.serviceimpl;

import com.shopstack.auth_service.dto.CustomerRegisterRequest;
import com.shopstack.auth_service.dto.VendorRegisterRequest;
import com.shopstack.auth_service.entity.*;
import com.shopstack.auth_service.repository.*;
import com.shopstack.auth_service.service.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.shopstack.auth_service.service.FileStorageService;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class RegistrationServiceImpl
        implements RegistrationService {

    private final UserRepository userRepository;
    private final CustomerRepository customerRepository;
    private final VendorRepository vendorRepository;
    private final PasswordEncoder passwordEncoder;
    private final FileStorageService fileStorageService;

    @Override
    public String registerCustomer(
            CustomerRegisterRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            return "Email already exists";
        }

        User user = User.builder()
                .fullName(request.getFullName())
                .email(request.getEmail())
                .password(
                        passwordEncoder.encode(
                                request.getPassword()))
                .phone(request.getPhone())
                .role(UserRole.CUSTOMER)
                .build();

        User savedUser = userRepository.save(user);

        Customer customer = Customer.builder()
                .user(savedUser)
                .gender(request.getGender())
                .build();

        customerRepository.save(customer);

        return "Customer Registered Successfully";
    }

    @Override
    public String registerVendor(
            VendorRegisterRequest request,
            MultipartFile businessLicenseDocument,
            MultipartFile gstDocument,
            MultipartFile panDocument) {

        if (userRepository.existsByEmail(request.getEmail())) {
            return "Email already exists";
        }

        String businessLicensePath =
                fileStorageService.storeFile(businessLicenseDocument);

        String gstDocumentPath =
                fileStorageService.storeFile(gstDocument);

        String panDocumentPath =
                fileStorageService.storeFile(panDocument);

        User user = User.builder()
                .fullName(request.getFullName())
                .email(request.getEmail())
                .password(
                        passwordEncoder.encode(
                                request.getPassword()))
                .phone(request.getPhone())
                .role(UserRole.VENDOR)
                .build();

        User savedUser = userRepository.save(user);

        Vendor vendor = Vendor.builder()
                .user(savedUser)
                .businessName(request.getBusinessName())
                .gstNumber(request.getGstNumber())
                .businessEmail(request.getBusinessEmail())
                .businessPhone(request.getBusinessPhone())
                .address(request.getAddress())
                .city(request.getCity())
                .state(request.getState())
                .pincode(request.getPincode())
                .businessRegistrationNumber(
                        request.getBusinessRegistrationNumber())

                .panNumber(
                        request.getPanNumber())

                .bankAccountNumber(
                        request.getBankAccountNumber())

                .ifscCode(
                        request.getIfscCode())

                .accountHolderName(
                        request.getAccountHolderName())

                .businessLicenseDocument(
                        businessLicensePath)

                .gstDocument(
                        gstDocumentPath)

                .panDocument(
                        panDocumentPath)

                .status(
                        VendorStatus.PENDING)

                .adminRemarks(
                        "Waiting for verification")
                .build();

        vendorRepository.save(vendor);

        return "Vendor Registered Successfully";
    }
}