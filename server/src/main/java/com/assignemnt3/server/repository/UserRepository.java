package com.assignemnt3.server.repository;

import com.assignemnt3.server.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByUserType(String userType);

    User findByUsernameAndPassword(String username, String password);

    User findByUsername(String username);

}
