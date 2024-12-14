package com.tradeconnect.tradeconnectapi.dto.Address;

public record AddressRequest (
        Long id,
        String street,
        String city,
        String state,
        String country,
        String zipCode,
        Long userId
){
}
