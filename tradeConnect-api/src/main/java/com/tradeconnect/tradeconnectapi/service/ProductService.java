package com.tradeconnect.tradeconnectapi.service;

import com.tradeconnect.tradeconnectapi.dto.ProductRequest;
import com.tradeconnect.tradeconnectapi.dto.ProductResponse;
import com.tradeconnect.tradeconnectapi.dto.UpdateProductRequest;
import com.tradeconnect.tradeconnectapi.mapper.ProductMapper;
import com.tradeconnect.tradeconnectapi.model.Product;
import com.tradeconnect.tradeconnectapi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    public Long addProduct(ProductRequest request) {
        Product product = productMapper.toProduct(request);
        productRepository.save(product);
        return product.getId();
    }

    public Page<ProductResponse> findAll(int page, int limit, String sortBy) {
        Pageable pageable = PageRequest.of(page - 1, limit, Sort.by(sortBy));
        Page<Product> productPage = productRepository.findAll(pageable);
        return productPage.map(productMapper::toProductResponse);
    }

    public ProductResponse findById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        return productMapper.toProductResponse(product);
    }

    public Long updateProductById(Long id, UpdateProductRequest productRequest) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        product.setName(productRequest.name());
        product.setDescription(productRequest.description());
        product.setPrice(productRequest.price());
        product.setAvilableQuantity(productRequest.avilableQuantity());
        product.setAvailable(productRequest.isAvailable());
        product.setFreeShipping(productRequest.isFreeShipping());
        product.setHidden(productRequest.isHidden());
        product.setProductImage(productRequest.ProductImage());

        productRepository.save(product);
        return product.getId();
    }

    public Long deleteProductById(Long id) {
        productRepository.deleteById(id);
        return id;
    }
}
