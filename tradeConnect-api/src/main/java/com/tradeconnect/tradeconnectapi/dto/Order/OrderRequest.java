package com.tradeconnect.tradeconnectapi.dto.Order;

import com.tradeconnect.tradeconnectapi.model.OrderType;

public record OrderRequest(
        OrderType orderType,
        int quantity,
        Long UserId,
        Long productId,
        Long address
) {
}
