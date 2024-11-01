package com.tradeconnect.tradeconnectapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "user_id")
    private int customerId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phoneNumber;
    private String address;

    // TODO: Add variables to photo
    // TODO: KYC Documents if they need to open a shop
}
