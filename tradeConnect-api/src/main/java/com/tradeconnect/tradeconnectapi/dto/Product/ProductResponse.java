package com.tradeconnect.tradeconnectapi.dto.Product;

import java.math.BigDecimal;

public record ProductResponse(
        int id,
        String name,
        String description,
        BigDecimal price,
        int avilableQuantity,
        boolean isAvailable,
        boolean isFreeShipping,
        boolean isHidden,
        byte[] ProductImage
) {
}
