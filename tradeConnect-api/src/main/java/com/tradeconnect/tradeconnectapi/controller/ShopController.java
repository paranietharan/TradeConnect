package com.tradeconnect.tradeconnectapi.controller;

import com.tradeconnect.tradeconnectapi.dto.Shop.ShopResponse;
import com.tradeconnect.tradeconnectapi.service.ShopService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
