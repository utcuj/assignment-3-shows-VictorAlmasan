package com.example.client.model;

public class Comment {

    private Long commentId;

    private Long userId;

    private Long showId;

    private String commentString;

    private Integer rating;


    public Comment() {
    }

    public Comment(Long userCommentId, Long userId, Long showId, String commentString, Integer rating) {
        this.commentId = userCommentId;
        this.userId = userId;
        this.showId = showId;
        this.commentString = commentString;
        this.rating = rating;
    }

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public String getCommentString() {
        return commentString;
    }

    public void setCommentString(String commentString) {
        this.commentString = commentString;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getShowId() {
        return showId;
    }

    public void setShowId(Long showId) {
        this.showId = showId;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }
}

