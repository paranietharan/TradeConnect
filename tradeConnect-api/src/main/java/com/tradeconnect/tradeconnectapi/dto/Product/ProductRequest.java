package com.tradeconnect.tradeconnectapi.dto.Product;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record ProductRequest(
        @NotNull(message = "Product name is required")
        String name,
        @NotNull(message = "Product description is required")
        String description,
        @Positive(message = "Product price must be greater than 0")
        BigDecimal price,
        @Positive(message = "Product available quantity must be greater than 0")
        int avilableQuantity,
        @NotNull(message = "Product availability is required")
        boolean isAvailable,
        @NotNull(message = "Product free shipping is required")
        boolean isFreeShipping,
        boolean isHidden,
        byte[] ProductImage,
        int categoryId,
        int shopId
) {
}
