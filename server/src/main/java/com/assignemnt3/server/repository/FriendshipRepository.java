package com.assignemnt3.server.repository;

import com.assignemnt3.server.model.Friendship;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FriendshipRepository extends JpaRepository<Friendship, Long> {

    List<Friendship> findByFirstUserId(Long userId);
}
