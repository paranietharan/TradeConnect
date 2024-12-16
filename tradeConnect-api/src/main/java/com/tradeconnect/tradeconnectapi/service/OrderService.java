package com.tradeconnect.tradeconnectapi.service;

import com.tradeconnect.tradeconnectapi.dto.Order.OrderRequest;
import com.tradeconnect.tradeconnectapi.dto.Order.OrderResponse;
import com.tradeconnect.tradeconnectapi.mapper.OrderMapper;
import com.tradeconnect.tradeconnectapi.model.Order;
import com.tradeconnect.tradeconnectapi.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    public OrderResponse createOrder(OrderRequest orderRequest) {
        Order newOrder = orderMapper.toOrder(orderRequest);
        Order savedOrder = orderRepository.save(newOrder);
        return orderMapper.toOrderResponse(savedOrder);
    }
}
