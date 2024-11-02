package com.tradeconnect.tradeconnectapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long customerId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phoneNumber;
    private String address;
    @Enumerated(EnumType.STRING)
    private Role role;

    // TODO: Add variables to photo
    // TODO: KYC Documents if they need to open a shop

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<Comment> comments;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<Order> orders;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<Shop> shops;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<Rating> ratings;
}
