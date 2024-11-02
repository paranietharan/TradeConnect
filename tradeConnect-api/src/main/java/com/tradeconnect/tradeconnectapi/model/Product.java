package com.tradeconnect.tradeconnectapi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "products")
@Getter
@Setter
public class Product {
    @Id
    private int id;
    private String name;
    private String description;
    private BigDecimal price;// BigDecimal is used to represent monetary values
    private int avilableQuantity;
    private boolean isAvailable;
    private boolean isFreeShipping;

    // TODO: Add Images

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shop_id")
    private Shop shop;

    @OneToMany(mappedBy = "product", cascade = CascadeType.REMOVE)
    private List<Rating> ratings;

    @OneToMany(mappedBy = "product", cascade = CascadeType.REMOVE)
    private List<Comment> comments;

    @OneToMany(mappedBy = "product", cascade = CascadeType.REMOVE)
    private List<Order> orders;
}
