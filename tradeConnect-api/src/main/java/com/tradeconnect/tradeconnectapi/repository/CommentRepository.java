package com.tradeconnect.tradeconnectapi.repository;

import com.tradeconnect.tradeconnectapi.dto.Comment.CommentResponse;
import com.tradeconnect.tradeconnectapi.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findAllByProductId(Long productId);
}
