package com.assignemnt3.server.service;

import com.assignemnt3.server.model.User;
import com.assignemnt3.server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public List<User> getAllRegularUsers() {
        return userRepository.findByUserType("regular");
    }

    public List<User> getAllPremiumUsers() {
        return userRepository.findByUserType("premium");
    }

    public User getById(Long userId) {
        return userRepository.getOne(userId);
    }

    public User getByUsernameAndPassword(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }

    public  void addUser(User user) {
        userRepository.save(user);
    }

    public void deleteById(Long userId) {
        userRepository.deleteById(userId);
    }

    public void editUser(User user) {
        User userToBeUpdated = userRepository.getOne(user.getUserId());
        userToBeUpdated.setUsername(user.getUsername());
        userToBeUpdated.setPassword(user.getPassword());
        userToBeUpdated.setUserType(user.getUserType());
        userRepository.save(userToBeUpdated);
    }
}
