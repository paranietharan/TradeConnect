package com.tradeconnect.tradeconnectapi.dto.Order;

import com.tradeconnect.tradeconnectapi.model.OrderStatus;
import com.tradeconnect.tradeconnectapi.model.OrderType;

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
