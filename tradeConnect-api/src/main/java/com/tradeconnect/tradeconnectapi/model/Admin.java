package com.tradeconnect.tradeconnectapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "admin")
public class Admin {
    @Id
    @Column(name = "admin_id")
    private long adminId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phone;

    // TODO: Add variables to photo
}
