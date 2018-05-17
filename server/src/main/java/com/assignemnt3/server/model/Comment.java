package com.assignemnt3.server.model;

import javax.persistence.*;

@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column
    private Long commentId;

    @Column
    private Long userId;

    @Column
    private Long showId;

    @Column
    private String commentString;

    @Column
    private Integer rating;


    public Comment() {
    }

    public Comment(Long commentId, Long userId, Long showId, String commentString, Integer rating) {
        this.commentId = commentId;
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
