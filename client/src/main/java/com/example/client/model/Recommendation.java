package com.example.client.model;


public class Recommendation {

    private Long recommendationId;

    private Long firstUserId;

    private String firstUserUsername;

    private Long secondUserId;

    private String secondUserUsername;

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
