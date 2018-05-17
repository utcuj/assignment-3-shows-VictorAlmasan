package com.assignemnt3.server.service;

import com.assignemnt3.server.model.History;
import com.assignemnt3.server.model.Show;
import com.assignemnt3.server.repository.HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HistoryService {

    @Autowired
    private HistoryRepository historyRepository;

    public void addHistory(History history) {
        historyRepository.save(history);
    }

}
