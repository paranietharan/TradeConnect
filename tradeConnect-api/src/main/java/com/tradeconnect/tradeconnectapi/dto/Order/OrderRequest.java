package com.tradeconnect.tradeconnectapi.dto.Order;

import com.tradeconnect.tradeconnectapi.model.OrderStatus;
import com.tradeconnect.tradeconnectapi.model.OrderType;

public record OrderRequest(
        OrderType orderType,
        double totalAmount,
        int quantity,
        boolean isProductDelivered,
        Long UserId,
        Long productId,
        Long address
) {
}
