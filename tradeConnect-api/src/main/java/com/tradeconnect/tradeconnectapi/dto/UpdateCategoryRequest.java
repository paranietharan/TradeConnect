package com.tradeconnect.tradeconnectapi.dto;

public record UpdateCategoryRequest(
        Integer id,
        String name,
        String description
) {
}
