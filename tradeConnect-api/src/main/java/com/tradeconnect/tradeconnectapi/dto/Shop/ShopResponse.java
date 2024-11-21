package com.tradeconnect.tradeconnectapi.dto.Shop;

public record ShopResponse(
        int id,
        String name,
        String address,
        String phone,
        String email,
        String website,
        String description,
        String shopType,
        byte[] logo,
        byte[] banner
) {
}
