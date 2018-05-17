package com.example.client.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@JsonIgnoreProperties(ignoreUnknown =  true)

public class History {

    private Long historyId;

    private Long userId;

    private Long showId;

    public History() {
        this(null, null, null);
    }

    public History(Long historyId, Long userId, Long showId) {
        this.historyId = historyId;
        this.userId = userId;
        this.showId = showId;
    }

    public Long getHistoryId() {
        return historyId;
    }

    public void setHistoryId(Long historyId) {
        this.historyId = historyId;
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
}
