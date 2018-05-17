package com.assignemnt3.server.controller;

import com.assignemnt3.server.model.User;
import com.assignemnt3.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/login")
public class LoginController {

    @Autowired
    private UserService userService;

    //@RequestMapping(value = "/loginIntoAccount/{username}/{password}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    //public @ResponseBody
    //User getByUsernameAndPassword(@PathVariable String username, @PathVariable String password) {
    //    return userService.getByUsernameAndPassword(username, password);
    //}

    @RequestMapping(value = "/login/{username}/{password}", method = RequestMethod.GET)
    public User login(Model model, @PathVariable String username,  @PathVariable String password) {
        return userService.getByUsernameAndPassword(username, password);
    }
}
