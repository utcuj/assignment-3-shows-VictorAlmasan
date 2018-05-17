package com.assignemnt3.server.service;

import com.assignemnt3.server.model.*;
import com.assignemnt3.server.repository.FriendshipRepository;
import com.assignemnt3.server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FriendshipService {

    @Autowired
    private FriendshipRepository friendshipRepository;

    @Autowired
    private UserRepository userRepository;

    public void addFriendship(Friendship friendship) {
        User user = userRepository.getOne(friendship.getSecondUserId());
        friendship.setSecondUserUsername(user.getUsername());
        friendshipRepository.save(friendship);
    }

    public List<Friendship> getAllFriendships() {
        return  friendshipRepository.findAll();
    }

    public List<Friendship> getAllFriendships(Long userId) {
        List<Friendship> friendshipList = friendshipRepository.findByFirstUserId(userId);
        return friendshipList;
    }

}
