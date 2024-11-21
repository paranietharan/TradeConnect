package com.tradeconnect.tradeconnectapi.dto.Category;

public record UpdateCategoryRequest(
        Long id,
        String name,
        String description
) {
}
