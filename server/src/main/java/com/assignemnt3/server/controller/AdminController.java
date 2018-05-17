package com.assignemnt3.server.controller;

import com.assignemnt3.server.model.Show;
import com.assignemnt3.server.model.User;
import com.assignemnt3.server.service.ShowService;
import com.assignemnt3.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private ShowService showService;

    // CRUD on users
    @RequestMapping(value = "/getAllUsers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @RequestMapping(value = "/getAllRegularUsers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    List<User> getAllRegularUsersUsers() {
        return userService.getAllRegularUsers();
    }

    @RequestMapping(value = "/getAllPremiumUsers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    List<User> getAllPremiumUsers() {
        return userService.getAllPremiumUsers();
    }

    @RequestMapping(value = "/getUserById/{userId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    User getUserById(@PathVariable Long userId) {
        return userService.getById(userId);
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> addUser(@RequestBody User user) {
        userService.addUser(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "/editUser", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> editUser(@RequestBody User user) {
        userService.editUser(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "/deleteUserById/{userId}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    void deleteUserById(@PathVariable Long userId) {
        userService.deleteById(userId);
    }



    // CRUD on shows
    @RequestMapping(value = "/getAllShows", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    List<Show> getAllShows() {
        return showService.getAllShows();
    }

    @RequestMapping(value = "/getAllMovies", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    List<Show> getAllMovies() {
        return showService.getAllMovies();
    }

    @RequestMapping(value = "/getAllTheatrePerformances", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    List<Show> getAllTheatrePerformances() {
        return showService.getAllTheatrePerformances();
    }

    @RequestMapping(value = "/getAllSportEvents", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    List<Show> getAllSportEvents() {
        return showService.getAllSportEvents();
    }

    @RequestMapping(value = "/getShowById/{showId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Show getShowById(@PathVariable Long showId) {
        return showService.getById(showId);
    }

    @RequestMapping(value = "/addShow", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Show> addShow(@RequestBody Show show) {
        showService.addShow(show);
        return new ResponseEntity<>(show, HttpStatus.OK);
    }

    @RequestMapping(value = "/editShow", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Show> editShow(@RequestBody Show show) {
        showService.editShow(show);
        return new ResponseEntity<>(show, HttpStatus.OK);
    }

    @RequestMapping(value = "/deleteShowById/{showId}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    void deleteShowById(@PathVariable Long showId) {
        showService.deleteById(showId);
    }

}
