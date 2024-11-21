package com.tradeconnect.tradeconnectapi.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "rating")
public class Rating {
    @Id
    private Long ratingId;
    private int rating;
    private Date date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;
}
