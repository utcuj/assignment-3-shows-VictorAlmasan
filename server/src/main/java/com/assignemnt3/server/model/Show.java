package com.assignemnt3.server.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "shows")
public class Show {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long showId;

    @Column
    private String showType;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private String actors;

    @Column
    //@Temporal(TemporalType.TIMESTAMP)
    //@DateTimeFormat("yyyy-MM-dd")
    private LocalDate date;

    @Column
    private String available;

    public Show() {
        this(null, null, null, null, null, null, null);
    }

    public Show(Long showId, String showType,String name, String description, String actors, LocalDate date, String available) {
        this.showId = showId;
        this.showType = showType;
        this.name = name;
        this.description = description;
        this.actors = actors;
        this.date = date;
        this.available = available;
    }

    public Long getShowId() {
        return showId;
    }

    public void setShowId(Long showId) {
        this.showId = showId;
    }

    public String getShowType() {
        return showType;
    }

    public void setShowType(String showType) {
        this.showType = showType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available;
    }
}
