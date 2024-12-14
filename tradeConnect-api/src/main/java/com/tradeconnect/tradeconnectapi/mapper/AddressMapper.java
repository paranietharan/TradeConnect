package com.tradeconnect.tradeconnectapi.mapper;

import com.tradeconnect.tradeconnectapi.dto.Address.AddressRequest;
import com.tradeconnect.tradeconnectapi.dto.Address.AddressResponse;
import com.tradeconnect.tradeconnectapi.model.Address;
import com.tradeconnect.tradeconnectapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper {

    private final UserRepository userRepository;

    @Autowired
    public AddressMapper(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Address toAddress(AddressRequest request) {
        return Address.builder()
                .street(request.street())
                .city(request.city())
                .state(request.state())
                .country(request.country())
                .zipCode(request.zipCode())
                .user(
                        userRepository.findById(request.userId())
                                .orElseThrow(() -> new RuntimeException("User not found"))
                )
                .build();
    }

    public AddressResponse toAddressResponse(Address address) {
        return new AddressResponse(
                address.getId(),
                address.getStreet(),
                address.getCity(),
                address.getState(),
                address.getCountry(),
                address.getZipCode(),
                address.getUser().getCustomerId()
        );
    }
}
