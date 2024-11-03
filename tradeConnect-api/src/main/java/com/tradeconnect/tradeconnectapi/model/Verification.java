package com.tradeconnect.tradeconnectapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Verification {
    @Id
    private String email;
    private String pin;
    private String firstName;
    private String lastName;
    private char[] password;
}
