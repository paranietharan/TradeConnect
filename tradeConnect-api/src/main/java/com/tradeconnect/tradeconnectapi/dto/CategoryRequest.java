package com.tradeconnect.tradeconnectapi.dto;

import jakarta.validation.constraints.NotNull;

public record CategoryRequest(
        @NotNull(message = "Category name cannot be empty")
        String name,
        @NotNull(message = "Category description cannot be empty")
        String description
) {
}
