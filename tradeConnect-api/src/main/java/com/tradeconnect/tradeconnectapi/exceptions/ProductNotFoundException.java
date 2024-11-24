package com.tradeconnect.tradeconnectapi.exceptions;

public class ProductNotFoundException extends Throwable {
    public ProductNotFoundException(Long productId) {
        super("Product not found with id: " + productId);
    }
}
