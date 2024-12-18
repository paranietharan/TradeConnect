package com.tradeconnect.tradeconnectapi.dto.Order;


public record OrderResponse(
        Long orderId,
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
