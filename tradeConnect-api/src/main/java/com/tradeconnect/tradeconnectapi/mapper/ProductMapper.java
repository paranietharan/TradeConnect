package com.tradeconnect.tradeconnectapi.mapper;

import com.tradeconnect.tradeconnectapi.dto.Product.ProductRequest;
import com.tradeconnect.tradeconnectapi.dto.Product.ProductResponse;
import com.tradeconnect.tradeconnectapi.model.Product;
import com.tradeconnect.tradeconnectapi.repository.CategoryRepository;
import com.tradeconnect.tradeconnectapi.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    private final CategoryRepository categoryRepository;
    private final ShopRepository shopRepository;

    @Autowired
    public ProductMapper(CategoryRepository categoryRepository, ShopRepository shopRepository) {
        this.categoryRepository = categoryRepository;
        this.shopRepository = shopRepository;
    }

    public Product toProduct(ProductRequest request) {
        boolean isHidden = request.isHidden() ? true : false;
        byte[] image = request.ProductImage();

        return Product.builder()
                .name(request.name())
                .description(request.description())
                .price(request.price())
                .avilableQuantity(request.avilableQuantity())
                .isAvailable(request.isAvailable())
                .isFreeShipping(request.isFreeShipping())
                .isHidden(isHidden)
                .ProductImage(image)
                .category(
                        categoryRepository.findById(request.categoryId())
                                .orElseThrow(() -> new RuntimeException("Category not found"))
                )
                .shop(
                        shopRepository.findById(request.shopId())
                                .orElseThrow(() -> new RuntimeException("Shop not found"))
                )
                .build();
    }

    public ProductResponse toProductResponse(Product product) {
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getAvilableQuantity(),
                product.isAvailable(),
                product.isFreeShipping(),
                product.isHidden(),
                product.getProductImage()
        );
    }
}
