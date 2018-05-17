package com.assignemnt3.server.controller;

import com.assignemnt3.server.model.Comment;
import com.assignemnt3.server.model.History;
import com.assignemnt3.server.model.Show;
import com.assignemnt3.server.service.CommentService;
import com.assignemnt3.server.service.HistoryService;
import com.assignemnt3.server.service.ShowService;
import com.assignemnt3.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/regularUser")
public class RegularUserController {

    @Autowired
    private ShowService showService;

    @Autowired
    private HistoryService historyService;

    @Autowired
    private CommentService commentService;

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


}
