package com.tradeconnect.tradeconnectapi.controller;

import com.tradeconnect.tradeconnectapi.dto.Address.AddressRequest;
import com.tradeconnect.tradeconnectapi.dto.Address.AddressResponse;
import com.tradeconnect.tradeconnectapi.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping
    public ResponseEntity<AddressResponse> editAddress(
            @RequestBody AddressRequest addressRequest
    ){
        return ResponseEntity.ok(addressService.editAddress(addressRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Integer> deleteAddress(
            @RequestParam Long id
    ){
        return ResponseEntity.ok(addressService.deleteAddress(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressResponse> getAddress(
            @RequestParam Long id
    ){
        return ResponseEntity.ok(addressService.getAddress(id));
    }
}
