package com.tradeconnect.tradeconnectapi.service;

import com.tradeconnect.tradeconnectapi.dto.Order.OrderRequest;
import com.tradeconnect.tradeconnectapi.dto.Order.OrderResponse;
import com.tradeconnect.tradeconnectapi.exceptions.OrderFailException;
import com.tradeconnect.tradeconnectapi.mapper.OrderMapper;
import com.tradeconnect.tradeconnectapi.model.Order;
import com.tradeconnect.tradeconnectapi.model.OrderStatus;
import com.tradeconnect.tradeconnectapi.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final ProductService productService;

    // method to create an order
    public OrderResponse createOrder(OrderRequest orderRequest) {
        Order newOrder = orderMapper.toOrder(orderRequest);

        if (!productService.hasStock(orderRequest.productId(), orderRequest.quantity())) {
            throw new OrderFailException("Insufficient stock for product ID: " + orderRequest.productId());
        }

        // If the item has stock update the count
        productService.updateStock(
                orderRequest.productId(),
                orderRequest.quantity()
        );

        Order savedOrder = orderRepository.save(newOrder);
        return orderMapper.toOrderResponse(savedOrder);
    }

    // method to cnacel an order
    public OrderResponse cancelOrder(Long orderId, Long userId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new OrderFailException("Order not found"));

        if (!order.getUser().getCustomerId().equals(userId)) {
            throw new OrderFailException("User not authorized to cancel this order");
        }

        if (order.getOrderStatus() != OrderStatus.PROCESSING && order.getOrderStatus() != OrderStatus.PACKED) {
            throw new OrderFailException("Order cannot be canceled as it is already " + order.getOrderStatus());
        }

        order.setOrderStatus(OrderStatus.CANCELED);
        Order savedOrder = orderRepository.save(order);
        return orderMapper.toOrderResponse(savedOrder);
    }

    // Method to change the order status to PACKED
    public OrderResponse packOrder(Long orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new OrderFailException("Order not found"));

        if (order.getOrderStatus() != OrderStatus.PROCESSING) {
            throw new OrderFailException("Order cannot be packed as it is already " + order.getOrderStatus());
        }

        order.setOrderStatus(OrderStatus.PACKED);
        Order savedOrder = orderRepository.save(order);
        return orderMapper.toOrderResponse(savedOrder);
    }

    // Method to change the order status to SHIPPED
    public OrderResponse shipOrder(Long orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new OrderFailException("Order not found"));

        if (order.getOrderStatus() != OrderStatus.PACKED) {
            throw new OrderFailException("Order cannot be shipped as it is already " + order.getOrderStatus());
        }

        order.setOrderStatus(OrderStatus.SHIPPED);
        Order savedOrder = orderRepository.save(order);
        return orderMapper.toOrderResponse(savedOrder);
    }
}
