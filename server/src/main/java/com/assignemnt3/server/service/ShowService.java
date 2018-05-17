package com.assignemnt3.server.service;

import com.assignemnt3.server.model.History;
import com.assignemnt3.server.model.Show;
import com.assignemnt3.server.repository.HistoryRepository;
import com.assignemnt3.server.repository.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ShowService {

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private HistoryRepository historyRepository;

    public List<Show> getAllShows() {
        return showRepository.findAll();
    }

    public List<Show> getAllWatchedShows(Long userId) {
        List<Show> showList = new ArrayList<>();
        List<History> historyList = historyRepository.findByUserId(userId);
        for(History h: historyList) {
            showList.add(showRepository.getOne(h.getShowId()));
        }
        return showList;
    }

    public List<Show> getAllMovies() {
        return showRepository.findByShowType("movie");
    }

    public List<Show> getAllTheatrePerformances() {
        return showRepository.findByShowType("theatre");
    }

    public List<Show> getAllSportEvents() {
        return showRepository.findByShowType("sport");
    }

    public Show getById(Long showId) {
        return showRepository.getOne(showId);
    }

    public Show getByName(String name) {
        return showRepository.findByName(name);
    }

    public void addShow(Show show) {
        showRepository.save(show);
    }

    public void deleteById(Long showId) {
        showRepository.deleteById(showId);
    }

    public void editShow(Show show) {
        Show showToBeUpdated = showRepository.getOne(show.getShowId());
        showToBeUpdated.setShowType(show.getShowType());
        showToBeUpdated.setName(show.getName());
        showToBeUpdated.setDescription(show.getDescription());
        showToBeUpdated.setActors(show.getActors());
        showToBeUpdated.setDate(show.getDate());
        showToBeUpdated.setAvailable(show.getAvailable());
        showRepository.save(showToBeUpdated);
    }



}
