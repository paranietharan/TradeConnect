package com.tradeconnect.tradeconnectapi.controller;

import com.tradeconnect.tradeconnectapi.dto.Order.OrderRequest;
import com.tradeconnect.tradeconnectapi.dto.Order.OrderResponse;
import com.tradeconnect.tradeconnectapi.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/orders")
@RequiredArgsConstructor
public class OrderController {
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderResponse> createOrder(
            @RequestBody OrderRequest orderRequest
    ){
        return ResponseEntity.ok(orderService.createOrder(orderRequest));
    }

    @PutMapping("/{orderId}/cancel")
    public ResponseEntity<OrderResponse> cancelOrder(
            @PathVariable Long orderId,
            @RequestParam Long userId
    ){
        return ResponseEntity.ok(orderService.cancelOrder(orderId, userId));
    }

    // TODO: Thease endpoints for sellers
    @PutMapping("/{orderId}/pack")
    public ResponseEntity<OrderResponse> packOrder(
            @PathVariable Long orderId
    ){
        return ResponseEntity.ok(orderService.packOrder(orderId));
    }

    // TODO: Thease endpoints for sellers
    @PutMapping("/{orderId}/ship")
    public ResponseEntity<OrderResponse> shipOrder(
            @PathVariable Long orderId
    ){
        return ResponseEntity.ok(orderService.shipOrder(orderId));
    }
}
