package com.tradeconnect.tradeconnectapi.controller;

import com.tradeconnect.tradeconnectapi.dto.Rating.RatingRequest;
import com.tradeconnect.tradeconnectapi.exceptions.ProductNotFoundException;
import com.tradeconnect.tradeconnectapi.service.RatingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/rating")
public class RatingController {
    private final RatingService ratingService;

    // Get the average rating of a product
    @GetMapping("/average/{productId}")
    public double getAverageRating(
            @PathVariable Long productId
    ) {
        try{
            return ratingService.getAverageRating(productId);
        } catch (Exception | ProductNotFoundException e) {
            return -1;
        }
    }

    // Rate a product
    @PutMapping
    public ResponseEntity<RatingRequest> rateProduct(
            @RequestBody RatingRequest ratingRequest
    ) {
        try {
            ratingService.rateProduct(ratingRequest);
            return ResponseEntity.ok(ratingRequest);
        } catch (Exception | ProductNotFoundException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
