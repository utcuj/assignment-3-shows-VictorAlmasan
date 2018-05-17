package com.example.client.controller;

import com.example.client.model.User;
import com.example.client.util.AppUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLogin(Model model) {
        return "login";
    }


    @RequestMapping ("/loginIntoAccount")
    public String loginUser(@ModelAttribute User user) {

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<User> responseEntity = restTemplate.getForEntity("http://localhost:8080/login/login/" + user.getUsername() + "/" + user.getPassword(), User.class);
        User user2 = responseEntity.getBody();

        if (user2 != null) {
            AppUtil.user = user2;
            System.out.println(AppUtil.user.toString());
            if ("admin".equalsIgnoreCase(user2.getUserType())) {
                return "redirect:/admin/home";
            }
            if ("premium".equalsIgnoreCase(user2.getUserType())) {
                return "redirect:/premiumUser/home";
            }
            if ("regular".equalsIgnoreCase(user2.getUserType())) {
                return "redirect:/regularUser/home";
            }
        }

        return "redirect:/login";
    }
}
