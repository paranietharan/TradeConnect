package com.tradeconnect.tradeconnectapi.dto.Comment;

import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record CommentRequest(
        @NotNull(message = "Comment cannot be null")
        String comment,
        @NotNull(message = "Date cannot be null")
        Date date,
        @NotNull(message = "Product ID cannot be null")
        Long productId,
        @NotNull(message = "User ID cannot be null")
        Long userId
) {
}
