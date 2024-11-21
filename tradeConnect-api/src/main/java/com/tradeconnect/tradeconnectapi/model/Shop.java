package com.tradeconnect.tradeconnectapi.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "shops")
public class Shop {
    @Id
    private Long id;
    private String name;
    private String address;
    private String phone;
    private String email;
    private String website;
    private String description;
    private String shopType;
    private byte[] logo;
    private byte[] banner;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}
