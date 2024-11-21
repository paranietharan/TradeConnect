package com.tradeconnect.tradeconnectapi.controller;

import com.tradeconnect.tradeconnectapi.dto.ProductRequest;
import com.tradeconnect.tradeconnectapi.dto.ProductResponse;
import com.tradeconnect.tradeconnectapi.dto.UpdateProductRequest;
import com.tradeconnect.tradeconnectapi.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;

    // add product
    @PostMapping
    public ResponseEntity<Long> addProduct(
            @RequestBody ProductRequest productRequest
    ) {
        return ResponseEntity.ok(productService.addProduct(productRequest));
    }

    // get all products
    @GetMapping
    public ResponseEntity<Page<ProductResponse>> getAllProducts(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "100") int limit,
            @RequestParam(defaultValue = "id") String sortBy
    ) {
        return ResponseEntity.ok(productService.findAll(page, limit, sortBy));
    }

    // get product by id
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProductById(
            @PathVariable Long id
    ) {
        return ResponseEntity.ok(productService.findById(id));
    }

    // update product by id
    @PutMapping("/{id}")
    public ResponseEntity<Long> updateProductById(
            @PathVariable Long id,
            @RequestBody UpdateProductRequest productRequest
    ) {
        return ResponseEntity.ok(productService.updateProductById(id, productRequest));
    }

    // delete product by id
    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteProductById(
            @PathVariable Long id
    ) {
        return ResponseEntity.ok(productService.deleteProductById(id));
    }
}
