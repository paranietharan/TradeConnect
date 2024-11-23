package com.tradeconnect.tradeconnectapi.service;

import com.tradeconnect.tradeconnectapi.dto.Comment.CommentRequest;
import com.tradeconnect.tradeconnectapi.model.Comment;
import com.tradeconnect.tradeconnectapi.repository.CommentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final UserService userService;
    private final ProductService productService;

    public CommentRequest commentProduct(CommentRequest commentRequest) {
        // check if user exists
        if(!userService.isUserExists(commentRequest.userId())) {
            throw new RuntimeException("User not found");
        }

        // check if product exists
        if(!productService.isProductExists(commentRequest.productId())) {
            throw new RuntimeException("Product not found");
        }

        // save comment
        commentRepository.save(
                Comment.builder()
                        .comment(commentRequest.comment())
                        .date(commentRequest.date())
                        .user(
                                userService.getUserById(commentRequest.userId())
                        )
                        .product(
                                productService.getProductById(commentRequest.productId())
                        )
                        .build()
        );
        return commentRequest;
    }


}
