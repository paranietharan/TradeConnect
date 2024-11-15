package com.tradeconnect.tradeconnectapi.controller;

import com.tradeconnect.tradeconnectapi.dto.ProductRequest;
import com.tradeconnect.tradeconnectapi.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;

    // add product
    @PostMapping
    public ResponseEntity<Integer> addProduct(
            @RequestBody ProductRequest productRequest
    ) {
        return ResponseEntity.ok(productService.addProduct(productRequest));
    }

}
