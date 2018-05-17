package com.assignemnt3.server.repository;

import com.assignemnt3.server.model.Comment;
import com.assignemnt3.server.model.History;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
