package com.tradeconnect.tradeconnectapi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "products")
@Getter
@Setter
public class Product {
    @Id
    private int id;
    private String name;
    private String description;
    private double price;
    private int avilableQuantity;
    private String category;
    private boolean isAvailable;
    private boolean isFreeShipping;

    // TODO: Add Images

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shop_id")
    private Shop shop;
}
