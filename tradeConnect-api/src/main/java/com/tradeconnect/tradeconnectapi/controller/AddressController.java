package com.tradeconnect.tradeconnectapi.controller;

import com.tradeconnect.tradeconnectapi.dto.Address.AddressRequest;
import com.tradeconnect.tradeconnectapi.dto.Address.AddressResponse;
import com.tradeconnect.tradeconnectapi.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/address")
@RequiredArgsConstructor
public class AddressController {

    private AddressService addressService;

    @PostMapping
    public ResponseEntity<AddressResponse> createAddress(
            @RequestBody AddressRequest addressRequest
            ){
        return ResponseEntity.ok(addressService.createAddress(addressRequest));
    }
}
