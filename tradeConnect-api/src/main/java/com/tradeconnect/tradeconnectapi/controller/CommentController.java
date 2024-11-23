package com.tradeconnect.tradeconnectapi.controller;

import com.tradeconnect.tradeconnectapi.dto.Comment.CommentRequest;
import com.tradeconnect.tradeconnectapi.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
