package com.tradeconnect.tradeconnectapi.dto.Rating;

public record RatingRequest(
        Long productId,
        Long userId,
        int rating
) {
}
