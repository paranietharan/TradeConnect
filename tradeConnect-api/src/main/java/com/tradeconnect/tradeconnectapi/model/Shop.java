package com.tradeconnect.tradeconnectapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "shops")
public class Shop {
    @Id
    private int id;
    private String name;
    private String address;
    private String phone;
    private String email;
    private String website;
    private String description;
    private String shopType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

}
