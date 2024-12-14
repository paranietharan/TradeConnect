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
}
