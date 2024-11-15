package com.tradeconnect.tradeconnectapi.service;

import com.tradeconnect.tradeconnectapi.dto.ProductRequest;
import com.tradeconnect.tradeconnectapi.mapper.ProductMapper;
import com.tradeconnect.tradeconnectapi.model.Product;
import com.tradeconnect.tradeconnectapi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Autowired
    public ProductService(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    public Integer addProduct(ProductRequest request) {
        Product product = productMapper.toProduct(request);
        productRepository.save(product);
        return product.getId();
    }
}
