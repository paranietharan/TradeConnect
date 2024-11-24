package com.tradeconnect.tradeconnectapi.service;

import com.tradeconnect.tradeconnectapi.dto.Comment.CommentRequest;
import com.tradeconnect.tradeconnectapi.dto.Comment.CommentResponse;
import com.tradeconnect.tradeconnectapi.model.Comment;
import com.tradeconnect.tradeconnectapi.repository.CommentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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


    public List<CommentResponse> getCommentsByProductId(Long productId) {
        // check if product exists
        if(!productService.isProductExists(productId)) {
            throw new RuntimeException("Product not found");
        }

        // get all comments of a product
        return commentRepository.findAllByProductId(productId)
                .stream()
                .map(comment -> new CommentResponse(
                        comment.getId(),
                        comment.getComment(),
                        comment.getDate(),
                        comment.getProduct().getId(),
                        comment.getUser().getCustomerId()
                ))
                .toList();
    }

    public void deleteComment(Long commentId) {
        // check if comment exists
        if(!commentRepository.existsById(commentId)) {
            throw new RuntimeException("Comment not found");
        }

        // delete comment
        commentRepository.deleteById(commentId);
    }
}
