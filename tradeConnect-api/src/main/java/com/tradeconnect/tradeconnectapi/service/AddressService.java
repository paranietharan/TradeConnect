package com.tradeconnect.tradeconnectapi.service;

import com.tradeconnect.tradeconnectapi.dto.Address.AddressRequest;
import com.tradeconnect.tradeconnectapi.dto.Address.AddressResponse;
import com.tradeconnect.tradeconnectapi.mapper.AddressMapper;
import com.tradeconnect.tradeconnectapi.model.Address;
import com.tradeconnect.tradeconnectapi.repository.AddressRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AddressService {
    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;

    public AddressResponse createAddress(AddressRequest addressRequest) {
        Address address = addressMapper.toAddress(addressRequest);
        Address savedAddress = addressRepository.save(address);
        return addressMapper.toAddressResponse(savedAddress);
    }

    public AddressResponse editAddress(AddressRequest addressRequest) {
        Address existingAddress = addressRepository.findById(addressRequest.id())
                .orElseThrow(() -> new RuntimeException("Address not found"));

        existingAddress.setStreet(addressRequest.street());
        existingAddress.setCity(addressRequest.city());
        existingAddress.setState(addressRequest.state());
        existingAddress.setCountry(addressRequest.country());
        existingAddress.setZipCode(addressRequest.zipCode());


        Address updatedAddress = addressRepository.save(existingAddress);
        return addressMapper.toAddressResponse(updatedAddress);
    }

    public Integer deleteAddress(Long id) {
        Address existingAddress = addressRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Address not found"));
        addressRepository.delete(existingAddress);
        return 1;
    }

    public AddressResponse getAddress(Long id) {
        Address address = addressRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Address not found"));
        return addressMapper.toAddressResponse(address);
    }
}
