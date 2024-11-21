package com.tradeconnect.tradeconnectapi.controller;

import com.tradeconnect.tradeconnectapi.dto.Shop.CreateShopRequest;
import com.tradeconnect.tradeconnectapi.dto.Shop.ShopResponse;
import com.tradeconnect.tradeconnectapi.dto.Shop.UpdateShopRequest;
import com.tradeconnect.tradeconnectapi.service.ShopService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/shops")
public class ShopController {
    private final ShopService shopService;

    // Get shop details by id
    @GetMapping("/{id}")
    public ResponseEntity<ShopResponse> getShopById(Long id) {
        return ResponseEntity.ok(shopService.getShopById(id));
    }

    // Get all shops
    @GetMapping
    public ResponseEntity<List<ShopResponse>> getAllShops() {
        return ResponseEntity.ok(shopService.getAllShops());
    }

    // Add a new shop
    @PostMapping
    public ResponseEntity<ShopResponse> addShop(
            @RequestBody CreateShopRequest createShopRequest
    ) {
        return ResponseEntity.ok(shopService.addShop(createShopRequest));
    }

    // Update a shop
    @PutMapping
    public ResponseEntity<ShopResponse> updateShop(
            @RequestBody UpdateShopRequest updateShopRequest
    ) {
        return ResponseEntity.ok(shopService.updateShop(updateShopRequest));
    }
}
