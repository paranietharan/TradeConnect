package com.tradeconnect.tradeconnectapi.dto.Address;

public record AddressResponse(
        Long id,
        String street,
        String city,
        String state,
        String country,
        String zipCode,
        Long userId
) {
}
