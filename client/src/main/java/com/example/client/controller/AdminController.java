package com.example.client.controller;

import com.example.client.model.Show;
import com.example.client.model.User;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String showAdminHomepage(Model model) {
        return "admin";
    }

    // USERS
    @RequestMapping(value = "/getAllUsers", method = RequestMethod.GET)
    public String viewAllUsers(Model model) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<User[]> responseEntity = restTemplate.getForEntity("http://localhost:8080/admin/getAllUsers", User[].class);
        User[] usersArray = responseEntity.getBody();

        List<User> users = new ArrayList<>();
        users.addAll(Arrays.asList(usersArray));
        model.addAttribute("users", users);
       return "adminViewUsers";
    }

    @RequestMapping(value = "/getAllRegularUsers", method = RequestMethod.GET)
    public String viewAllRegularUsers(Model model) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<User[]> responseEntity = restTemplate.getForEntity("http://localhost:8080/admin/getAllRegularUsers", User[].class);
        User[] usersArray = responseEntity.getBody();

        List<User> users = new ArrayList<>();
        users.addAll(Arrays.asList(usersArray));
        model.addAttribute("users", users);
        return "adminViewUsers";
    }

    @RequestMapping(value = "/getAllPremiumUsers", method = RequestMethod.GET)
    public String viewAllPremiumUsers(Model model) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<User[]> responseEntity = restTemplate.getForEntity("http://localhost:8080/admin/getAllPremiumUsers", User[].class);
        User[] usersArray = responseEntity.getBody();

        List<User> users = new ArrayList<>();
        users.addAll(Arrays.asList(usersArray));
        model.addAttribute("users", users);
        return "adminViewUsers";
    }



    @RequestMapping("/deleteUser/{userId}")
    public String deleteUser(@PathVariable Integer userId) {

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.exchange("http://localhost:8080/admin/deleteUserById/" + userId, HttpMethod.DELETE, null, User.class);

        return "redirect:/admin/getAllUsers";
    }

    @RequestMapping(value = "/editUser", method = RequestMethod.POST)
    public String editUser(Model model, @ModelAttribute("user") User user) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<User> request = new HttpEntity<>(user, headers);
        restTemplate.exchange( "http://localhost:8080/admin/editUser", HttpMethod.PUT, request , User.class);
        return "redirect:/admin/getAllUsers";
    }

    @RequestMapping(value = "/editUser/{userId}", method = RequestMethod.GET)
    public String showEditUser(Model model, @PathVariable Integer userId) {
        RestTemplate restTemplate = new RestTemplate();
        User user  = restTemplate.getForObject("http://localhost:8080/admin/getUserById/" + userId, User.class);
        model.addAttribute("user", user);
        return "adminEditUser";
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.GET)
    public String showAddUser(Model model) {
        return "adminAddUser";
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("user") User user) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<User> request = new HttpEntity<>(user, headers);
        restTemplate.postForEntity( "http://localhost:8080/admin/addUser", request , User.class );
        return "redirect:/admin/getAllUsers";
    }

    //SHOWS
    @RequestMapping(value = "/getAllShows", method = RequestMethod.GET)
    public String viewAllShows(Model model) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Show[]> responseEntity = restTemplate.getForEntity("http://localhost:8080/admin/getAllShows", Show[].class);
        Show[] showsArray = responseEntity.getBody();

        List<Show> shows = new ArrayList<>();
        shows.addAll(Arrays.asList(showsArray));
        model.addAttribute("shows", shows);
        return "adminViewShows";
    }

    @RequestMapping(value = "/getAllMovies", method = RequestMethod.GET)
    public String viewAllMovies(Model model) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Show[]> responseEntity = restTemplate.getForEntity("http://localhost:8080/admin/getAllMovies", Show[].class);
        Show[] showsArray = responseEntity.getBody();

        List<Show> shows = new ArrayList<>();
        shows.addAll(Arrays.asList(showsArray));
        model.addAttribute("shows", shows);
        return "adminViewShows";
    }

    @RequestMapping(value = "/getAllTheatrePerformances", method = RequestMethod.GET)
    public String viewAllTheatrePerformances(Model model) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Show[]> responseEntity = restTemplate.getForEntity("http://localhost:8080/admin/getAllTheatrePerformances", Show[].class);
        Show[] showsArray = responseEntity.getBody();

        List<Show> shows = new ArrayList<>();
        shows.addAll(Arrays.asList(showsArray));
        model.addAttribute("shows", shows);
        return "adminViewShows";
    }

    @RequestMapping(value = "/getAllSportEvents", method = RequestMethod.GET)
    public String viewAllSportEvents(Model model) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Show[]> responseEntity = restTemplate.getForEntity("http://localhost:8080/admin/getAllSportEvents", Show[].class);
        Show[] showsArray = responseEntity.getBody();

        List<Show> shows = new ArrayList<>();
        shows.addAll(Arrays.asList(showsArray));
        model.addAttribute("shows", shows);
        return "adminViewShows";
    }

    @RequestMapping("/deleteShow/{showId}")
    public String deleteShow(@PathVariable Integer showId) {

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.exchange("http://localhost:8080/admin/deleteShowById/" + showId, HttpMethod.DELETE, null, Show.class);

        return "redirect:/admin/getAllShows";
    }

    @RequestMapping(value = "/editShow", method = RequestMethod.POST)
    public String editShow(@Valid Model model, @ModelAttribute("show") @Valid Show show) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<Show> request = new HttpEntity<>(show, headers);
        restTemplate.exchange( "http://localhost:8080/admin/editShow", HttpMethod.PUT, request , Show.class);
        return "redirect:/admin/getAllShows";
    }

    @RequestMapping(value = "/editShow/{showId}", method = RequestMethod.GET)
    public String showEditShow(@Valid Model model, @PathVariable @Valid Integer showId) {
        RestTemplate restTemplate = new RestTemplate();
        Show show  = restTemplate.getForObject("http://localhost:8080/admin/getShowById/" + showId, Show.class);
        model.addAttribute("show", show);
        return "adminEditShow";
    }

    @RequestMapping(value = "/addShow", method = RequestMethod.GET)
    public String showAddShow(Model model) {
        return "adminAddShow";
    }

    @RequestMapping(value = "/addShow", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("show") Show show) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Show> request = new HttpEntity<>(show, headers);
        restTemplate.postForEntity( "http://localhost:8080/admin/addShow", request , Show.class );
        return "redirect:/admin/getAllShows";
    }

}
