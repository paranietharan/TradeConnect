package com.tradeconnect.tradeconnectapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "admin")
public class Admin {
    @Id
    @Column(name = "admin_id")
    private int adminId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
