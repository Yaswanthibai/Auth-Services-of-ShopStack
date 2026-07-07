package com.shopstack.auth_service.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="customers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long customerId;

    @OneToOne
    @JoinColumn(name="user_id")
    private User user;

    private String gender;

    private String address;

    private String city;

    private String state;

    private String pincode;
}