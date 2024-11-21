package com.tradeconnect.tradeconnectapi.dto.Category;

import jakarta.validation.constraints.NotNull;

public record CategoryRequest(
        @NotNull(message = "Category name cannot be empty")
        String name,
        @NotNull(message = "Category description cannot be empty")
        String description
) {
}
