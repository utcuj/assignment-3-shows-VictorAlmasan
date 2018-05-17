package com.assignemnt3.server.model;

import javax.persistence.*;

@Entity
@Table(name = "recommendations")
public class Recommendation {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column
    private Long recommendationId;

    @Column
    private Long firstUserId;

    @Column
    private String firstUserUsername;

    @Column
    private Long secondUserId;

    @Column
    private String secondUserUsername;

    @Column
    private Long showId;

    public Recommendation() {
    }

    public Recommendation(Long recommendationId, Long firstUserId, String firstUserUsername, Long secondUserId, String secondUserUsername, Long showId) {
        this.recommendationId = recommendationId;
        this.firstUserId = firstUserId;
        this.firstUserUsername = firstUserUsername;
        this.secondUserId = secondUserId;
        this.secondUserUsername = secondUserUsername;
        this.showId = showId;
    }

    public Long getRecommendationId() {
        return recommendationId;
    }

    public void setRecommendationId(Long recommendationId) {
        this.recommendationId = recommendationId;
    }

    public Long getFirstUserId() {
        return firstUserId;
    }

    public void setFirstUserId(Long firstUserId) {
        this.firstUserId = firstUserId;
    }

    public String getFirstUserUsername() {
        return firstUserUsername;
    }

    public void setFirstUserUsername(String firstUserUsername) {
        this.firstUserUsername = firstUserUsername;
    }

    public Long getSecondUserId() {
        return secondUserId;
    }

    public void setSecondUserId(Long secondUserId) {
        this.secondUserId = secondUserId;
    }

    public String getSecondUserUsername() {
        return secondUserUsername;
    }

    public void setSecondUserUsername(String secondUserUsername) {
        this.secondUserUsername = secondUserUsername;
    }

    public Long getShowId() {
        return showId;
    }

    public void setShowId(Long showId) {
        this.showId = showId;
    }
}
