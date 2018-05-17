package com.example.client.controller;

import com.example.client.model.*;
import com.example.client.util.AppUtil;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/premiumUser")
public class PremiumUserController {

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String showpremiumUserHomepage(Model model) {
        return "premiumUser";
    }

    @RequestMapping(value = "/getAllShows", method = RequestMethod.GET)
    public String viewAllShows(Model model) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Show[]> responseEntity = restTemplate.getForEntity("http://localhost:8080/premiumUser/getAllShows", Show[].class);
        Show[] showsArray = responseEntity.getBody();

        List<Show> shows = new ArrayList<>();
        shows.addAll(Arrays.asList(showsArray));
        model.addAttribute("shows", shows);
        return "premiumUserViewShows";
    }

    @RequestMapping(value = "/getAllWatchedShows", method = RequestMethod.GET)
    public String viewAllWatchedShows(Model model) {
        RestTemplate restTemplate = new RestTemplate();
        Long userId = AppUtil.user.getUserId();
        ResponseEntity<Show[]> responseEntity = restTemplate.getForEntity("http://localhost:8080/premiumUser/getAllWatchedShows/" + userId, Show[].class);
        Show[] showsArray = responseEntity.getBody();

        List<Show> shows = new ArrayList<>();
        shows.addAll(Arrays.asList(showsArray));
        model.addAttribute("shows", shows);
        return "premiumUserViewShows";
    }


    @RequestMapping(value = "/addHistory/{showId}", method = RequestMethod.GET)
    public String addHistory(@PathVariable Long showId) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        History history = new History(null, AppUtil.user.getUserId(), showId);
        HttpEntity<History> request = new HttpEntity<>(history, headers);
        restTemplate.postForEntity( "http://localhost:8080/premiumUser/addHistory", request , History.class );
        return "redirect:/premiumUser/getAllShows";
    }




    @RequestMapping(value = "/addCommentAndRating", method = RequestMethod.POST)
    public String addCommentAndRating(@ModelAttribute("show") Show show, @ModelAttribute("comment") @Valid Comment comment) {
        comment.setUserId(AppUtil.user.getUserId());
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Comment> request = new HttpEntity<>(comment, headers);
        restTemplate.postForEntity( "http://localhost:8080/premiumUser/addCommentAndRating", request , Comment.class );
        return "redirect:/premiumUser/getAllShows";
    }

    @RequestMapping(value = "/addCommentAndRating/{showId}", method = RequestMethod.GET)
    public String showAddCommentAndRating(@Valid Model model, @PathVariable @Valid Long showId) {
        RestTemplate restTemplate = new RestTemplate();
        Show show  = restTemplate.getForObject("http://localhost:8080/premiumUser/getShowById/" + showId, Show.class);

        Comment comment = new Comment();
        comment.setCommentId(Long.valueOf(0));
        comment.setCommentString("");
        comment.setRating(0);
        comment.setShowId(show.getShowId());
        comment.setUserId(AppUtil.user.getUserId());
        model.addAttribute("comment", comment);
        model.addAttribute("show", show);
        System.out.println("Am ajuns aici 2");
        return "premiumUserAddComAndRtg";
    }


    @RequestMapping(value = "/getAllComments", method = RequestMethod.GET)
    public String viewAllComments(Model model) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Comment[]> responseEntity = restTemplate.getForEntity("http://localhost:8080/premiumUser/getAllComments", Comment[].class);
        Comment[] commentsArray = responseEntity.getBody();

        List<Comment> comments = new ArrayList<>();
        comments.addAll(Arrays.asList(commentsArray));
        model.addAttribute("comments", comments);
        return "premiumUserViewComments";
    }


    // premium

    @RequestMapping(value = "/getAllPremiumUsers", method = RequestMethod.GET)
    public String viewAllPremiumUsers(Model model) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<User[]> responseEntity = restTemplate.getForEntity("http://localhost:8080/premiumUser/getAllPremiumUsers", User[].class);
        User[] usersArray = responseEntity.getBody();

        List<User> users = new ArrayList<>();
        users.addAll(Arrays.asList(usersArray));
        users = users.stream().filter(p -> p.getUserId() != AppUtil.user.getUserId()).collect(Collectors.toList());

        model.addAttribute("users", users);
        return "premiumUserViewUsers";
    }


    @RequestMapping(value = "/addFriendship/{userId}", method = RequestMethod.GET)
    public String addFriendship(@PathVariable Long userId) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        Friendship friendship = new Friendship();
        friendship.setFriendshipId(Long.valueOf(0));
        friendship.setFirstUserId(AppUtil.user.getUserId());
        friendship.setSecondUserId(userId);
        friendship.setSecondUserUsername("");

        HttpEntity<Friendship> request = new HttpEntity<>(friendship, headers);
        restTemplate.postForEntity( "http://localhost:8080/premiumUser/addFriendship", request , Friendship.class );
        return "redirect:/premiumUser/getAllShows";
    }


    @RequestMapping(value = "/getAllFriendships", method = RequestMethod.GET)
    public String viewAllFriendships(Model model) {
        RestTemplate restTemplate = new RestTemplate();
        Long userId = AppUtil.user.getUserId();
        ResponseEntity<Friendship[]> responseEntity = restTemplate.getForEntity("http://localhost:8080/premiumUser/getAllFriendships/" + userId, Friendship[].class);
        Friendship[] friendshipsArray = responseEntity.getBody();

        List<Friendship> friendships = new ArrayList<>();
        friendships.addAll(Arrays.asList(friendshipsArray));
        model.addAttribute("friendships", friendships);
        return "premiumUserViewFriendships";
    }


    @RequestMapping(value = "/recommendShow", method = RequestMethod.POST)
    public String recommendShow(@ModelAttribute("show") Show show, @ModelAttribute("recommendation") @Valid Recommendation recommendation) {
        recommendation.setFirstUserId(AppUtil.user.getUserId());
        recommendation.setFirstUserUsername(AppUtil.user.getUsername());
        recommendation.setShowId(show.getShowId());
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Recommendation> request = new HttpEntity<>(recommendation, headers);
        restTemplate.postForEntity( "http://localhost:8080/premiumUser/recommendShow", request , Comment.class );
        return "redirect:/premiumUser/getAllShows";
    }

    @RequestMapping(value = "/recommendShow/{showId}", method = RequestMethod.GET)
    public String viewRecommendShow(@Valid Model model, @PathVariable @Valid Long showId) {
        RestTemplate restTemplate = new RestTemplate();
        Show show  = restTemplate.getForObject("http://localhost:8080/premiumUser/getShowById/" + showId, Show.class);

        Recommendation recommendation = new Recommendation();
        recommendation.setRecommendationId(Long.valueOf(0));
        recommendation.setFirstUserId(AppUtil.user.getUserId());
        recommendation.setSecondUserId(Long.valueOf(0));
        recommendation.setSecondUserUsername("");
        recommendation.setShowId(Long.valueOf(0));

        model.addAttribute("recommendation", recommendation);
        model.addAttribute("show", show);
        return "premiumUserRecommendShow";
    }

    // toate recomandarile primit de user-ul logat
    @RequestMapping(value = "/getAllRecommendations", method = RequestMethod.GET)
    public String viewAllRecommendations(Model model) {
        RestTemplate restTemplate = new RestTemplate();
        Long userId = AppUtil.user.getUserId();
        ResponseEntity<Recommendation[]> responseEntity = restTemplate.getForEntity("http://localhost:8080/premiumUser/getAllRecommendations/" + userId, Recommendation[].class);
        Recommendation[] recommendationsArray = responseEntity.getBody();

        List<Recommendation> recommendations = new ArrayList<>();
        recommendations.addAll(Arrays.asList(recommendationsArray));
        model.addAttribute("recommendations", recommendations);
        return "premiumUserViewRecommendations";
    }

    @RequestMapping(value = "/getAllRecommendationsYouHaveSent", method = RequestMethod.GET)
    public String viewAllRecommendationsYouHaveSent(Model model) {
        RestTemplate restTemplate = new RestTemplate();
        Long userId = AppUtil.user.getUserId();
        ResponseEntity<Recommendation[]> responseEntity = restTemplate.getForEntity("http://localhost:8080/premiumUser/getAllRecommendationsYouHaveSent/" + userId, Recommendation[].class);
        Recommendation[] recommendationsArray = responseEntity.getBody();

        List<Recommendation> recommendations = new ArrayList<>();
        recommendations.addAll(Arrays.asList(recommendationsArray));
        model.addAttribute("recommendations", recommendations);
        return "premiumUserViewRecommendations";
    }


}
