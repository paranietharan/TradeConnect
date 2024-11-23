package com.tradeconnect.tradeconnectapi.repository;

import com.tradeconnect.tradeconnectapi.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
