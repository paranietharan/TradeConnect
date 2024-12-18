package com.tradeconnect.tradeconnectapi.mapper;

import com.tradeconnect.tradeconnectapi.dto.Order.OrderRequest;
import com.tradeconnect.tradeconnectapi.dto.Order.OrderResponse;
import com.tradeconnect.tradeconnectapi.model.*;
import com.tradeconnect.tradeconnectapi.repository.AddressRepository;
import com.tradeconnect.tradeconnectapi.repository.ProductRepository;
import com.tradeconnect.tradeconnectapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {

    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final AddressRepository addressRepository;

    @Autowired
    public OrderMapper(UserRepository userRepository, ProductRepository productRepository, AddressRepository addressRepository) {
        this.userRepository = userRepository;
        this.productRepository = productRepository;
        this.addressRepository = addressRepository;
    }

    public Order toOrder(OrderRequest request) {
        User user = userRepository.findById(request.UserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        Product product = productRepository.findById(request.productId())
                .orElseThrow(() -> new RuntimeException("Product not found"));
        Address address = addressRepository.findById(request.address())
                .orElseThrow(() -> new RuntimeException("Address not found"));

        return Order.builder()
                .orderType(request.orderType())
                .quantity(request.quantity())
                .user(user)
                .product(product)
                .shippingAddress(address)
                .orderStatus(OrderStatus.PROCESSING) // Default value
                .build();
    }

    public OrderResponse toOrderResponse(Order order) {
        return new OrderResponse(
                order.getId(),
                order.getOrderType().name(),
                order.getTotalAmount(),
                order.getQuantity(),
                order.getOrderStatus().name(),
                order.isProductDelivered(),
                order.getUser().getCustomerId(),
                order.getProduct().getId(),
                order.getShippingAddress().getId()
        );
    }
}
