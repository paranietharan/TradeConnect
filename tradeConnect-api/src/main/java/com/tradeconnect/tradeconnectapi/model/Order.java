package com.tradeconnect.tradeconnectapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    private int id;
    private String orderStatus;
    @Enumerated(EnumType.STRING)
    private OrderType orderType;
    private double totalAmount;
    private int quantity;
    private String shippingAddress;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;
}
