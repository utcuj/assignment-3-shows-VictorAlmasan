package com.assignemnt3.server.controller;

import com.assignemnt3.server.model.*;
import com.assignemnt3.server.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/premiumUser")
public class PremiumUserController {

    @Autowired
    private ShowService showService;

    @Autowired
    private HistoryService historyService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private UserService userService;

    @Autowired
    private FriendshipService friendshipService;

    @Autowired
    private RecommendationService recommendationService;

    @RequestMapping(value = "/getAllShows", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    List<Show> getAllShows() {
        return showService.getAllShows();
    }

    @RequestMapping(value = "/getAllWatchedShows/{userId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    List<Show> getAllShows(@PathVariable Long userId) {
        return showService.getAllWatchedShows(userId);
    }

    @RequestMapping(value = "/addHistory", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<History> addHistory(@RequestBody History history) {
        historyService.addHistory(history);
        return new ResponseEntity<>(history, HttpStatus.OK);
    }

    @RequestMapping(value = "/getShowById/{showId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Show getShowById(@PathVariable Long showId) {
        return showService.getById(showId);
    }

    @RequestMapping(value = "/addCommentAndRating", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Comment> addComment(@RequestBody Comment comment) {
        commentService.addComment(comment);
        return new ResponseEntity<>(comment, HttpStatus.OK);
    }

    @RequestMapping(value = "/getAllComments", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    List<Comment> getAllComments() {
        return commentService.getAllComments();
    }


    @RequestMapping(value = "/getAllPremiumUsers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    List<User> getAllPremiumUsers() {
        return userService.getAllPremiumUsers();
    }

    @RequestMapping(value = "/addFriendship", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Friendship> addFriendship(@RequestBody Friendship friendship) {
        friendshipService.addFriendship(friendship);
        return new ResponseEntity<>(friendship, HttpStatus.OK);
    }

    @RequestMapping(value = "/getAllFriendships/{userId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    List<Friendship> getAllFriendships(@PathVariable Long userId) {
        return friendshipService.getAllFriendships(userId);
    }

    @RequestMapping(value = "/recommendShow", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Recommendation> recommendShow(@RequestBody Recommendation recommendation) {
        recommendationService.addRecommendation(recommendation);
        return new ResponseEntity<>(recommendation, HttpStatus.OK);
    }

    @RequestMapping(value = "/getAllRecommendations/{userId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    List<Recommendation> getAllRecommendations(@PathVariable Long userId) {
        return recommendationService.getAllRecommendations(userId);
    }

    @RequestMapping(value = "/getAllRecommendationsYouHaveSent/{userId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    List<Recommendation> getAllRecommendationsYouHaveSent(@PathVariable Long userId) {
        return recommendationService.getAllRecommendationsYouHaveSent(userId);
    }
}
