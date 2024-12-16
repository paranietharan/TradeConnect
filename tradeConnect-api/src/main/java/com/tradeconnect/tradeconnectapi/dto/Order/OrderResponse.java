package com.tradeconnect.tradeconnectapi.dto.Order;


public record OrderResponse(
        String orderType,
        double totalAmount,
        int quantity,
        String orderStatus,
        boolean isProductDelivered,
        Long UserId,
        Long productId,
        Long address
) {
}
