package com.tradeconnect.tradeconnectapi.service;

import com.tradeconnect.tradeconnectapi.dto.Rating.RatingRequest;
import com.tradeconnect.tradeconnectapi.exceptions.ProductNotFoundException;
import com.tradeconnect.tradeconnectapi.model.Rating;
import com.tradeconnect.tradeconnectapi.repository.RatingRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RatingService {
    private final RatingRepository ratingRepository;
    private final ProductService productService;
    private final UserService userService;

    public double getAverageRating(Long productId) throws ProductNotFoundException {
        // Check the product is exists
        if(!productService.isProductExists(productId)) {
            throw new ProductNotFoundException(productId);
        }

        // Get the average rating of the product
        return ratingRepository.getAverageRating(productId);
    }

    public void rateProduct(RatingRequest ratingRequest) throws ProductNotFoundException {
        // Check the product is exists
        if(!productService.isProductExists(ratingRequest.productId())) {
            throw new ProductNotFoundException(ratingRequest.productId());
        }

        // Rate the product
        ratingRepository.save(
                Rating.builder()
                        .user(
                                userService.getUserById(ratingRequest.userId())
                        )
                        .rating(ratingRequest.rating())
                        .product(
                                productService.getProductById(ratingRequest.productId())
                        )
                        .build()
        );
    }
}
