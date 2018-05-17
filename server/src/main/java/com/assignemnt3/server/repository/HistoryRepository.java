package com.assignemnt3.server.repository;

import com.assignemnt3.server.model.History;
import com.assignemnt3.server.model.Show;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HistoryRepository extends JpaRepository<History, Long> {

    List<History> findByUserId(Long userId);
}
