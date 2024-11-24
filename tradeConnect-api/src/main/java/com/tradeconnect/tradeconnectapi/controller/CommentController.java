package com.tradeconnect.tradeconnectapi.controller;

import com.tradeconnect.tradeconnectapi.dto.Comment.CommentRequest;
import com.tradeconnect.tradeconnectapi.dto.Comment.CommentResponse;
import com.tradeconnect.tradeconnectapi.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/comment")
public class CommentController {
    private final CommentService commentService;

    // comment a product
    @PostMapping
    public ResponseEntity<CommentRequest> commentProduct(
            @RequestBody CommentRequest commentRequest
    ) {
        return ResponseEntity.ok(commentService.commentProduct(commentRequest));
    }

    // Get all comments of a product
    @GetMapping("/{productId}")
    public ResponseEntity<List<CommentResponse>> getCommentsByProductId(
            @PathVariable Long productId
    ) {
        return ResponseEntity.ok(commentService.getCommentsByProductId(productId));
    }

    // Delete a comment
    @DeleteMapping("/{commentId}")
    public ResponseEntity<String> deleteComment(
            @PathVariable Long commentId
    ) {
        commentService.deleteComment(commentId);
        return ResponseEntity.ok("Comment deleted successfully");
    }
}
