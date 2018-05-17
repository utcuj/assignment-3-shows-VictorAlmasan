package com.example.client.controller;

import com.example.client.model.Comment;
import com.example.client.model.History;
import com.example.client.model.Show;
import com.example.client.model.User;
import com.example.client.util.AppUtil;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping(value = "/regularUser")
public class RegularUserController {

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String showRegularUserHomepage(Model model) {
        return "regularUser";
    }

    @RequestMapping(value = "/getAllShows", method = RequestMethod.GET)
    public String viewAllShows(Model model) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Show[]> responseEntity = restTemplate.getForEntity("http://localhost:8080/regularUser/getAllShows", Show[].class);
        Show[] showsArray = responseEntity.getBody();

        List<Show> shows = new ArrayList<>();
        shows.addAll(Arrays.asList(showsArray));
        model.addAttribute("shows", shows);
        return "regularUserViewShows";
    }

    @RequestMapping(value = "/getAllWatchedShows", method = RequestMethod.GET)
    public String viewAllWatchedShows(Model model) {
        RestTemplate restTemplate = new RestTemplate();
        Long userId = AppUtil.user.getUserId();
        ResponseEntity<Show[]> responseEntity = restTemplate.getForEntity("http://localhost:8080/regularUser/getAllWatchedShows/" + userId, Show[].class);
        Show[] showsArray = responseEntity.getBody();

        List<Show> shows = new ArrayList<>();
        shows.addAll(Arrays.asList(showsArray));
        model.addAttribute("shows", shows);
        return "regularUserViewShows";
    }


    @RequestMapping(value = "/addHistory/{showId}", method = RequestMethod.GET)
    public String addHistory(@PathVariable Long showId) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        History history = new History(null, AppUtil.user.getUserId(), showId);
        HttpEntity<History> request = new HttpEntity<>(history, headers);
        restTemplate.postForEntity( "http://localhost:8080/regularUser/addHistory", request , History.class );
        return "redirect:/regularUser/getAllShows";
    }




    @RequestMapping(value = "/addCommentAndRating", method = RequestMethod.POST)
    public String addCommentAndRating(@ModelAttribute("show") Show show, @ModelAttribute("comment") @Valid Comment comment) {
        comment.setUserId(AppUtil.user.getUserId());
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Comment> request = new HttpEntity<>(comment, headers);
        restTemplate.postForEntity( "http://localhost:8080/regularUser/addCommentAndRating", request , Comment.class );
        return "redirect:/regularUser/getAllShows";
    }

    @RequestMapping(value = "/addCommentAndRating/{showId}", method = RequestMethod.GET)
    public String showAddCommentAndRating(@Valid Model model, @PathVariable @Valid Long showId) {
        RestTemplate restTemplate = new RestTemplate();
        Show show  = restTemplate.getForObject("http://localhost:8080/regularUser/getShowById/" + showId, Show.class);

        Comment comment = new Comment();
        comment.setCommentId(Long.valueOf(0));
        comment.setCommentString("");
        comment.setRating(0);
        comment.setShowId(show.getShowId());
        comment.setUserId(AppUtil.user.getUserId());
        model.addAttribute("comment", comment);
        model.addAttribute("show", show);
        return "regularUserAddComAndRtg";
    }


    @RequestMapping(value = "/getAllComments", method = RequestMethod.GET)
    public String viewAllComments(Model model) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Comment[]> responseEntity = restTemplate.getForEntity("http://localhost:8080/regularUser/getAllComments", Comment[].class);
        Comment[] commentsArray = responseEntity.getBody();

        List<Comment> comments = new ArrayList<>();
        comments.addAll(Arrays.asList(commentsArray));
        model.addAttribute("comments", comments);
        return "regularUserViewComments";
    }
}
