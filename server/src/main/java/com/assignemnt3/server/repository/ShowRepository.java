package com.assignemnt3.server.repository;

import com.assignemnt3.server.model.Show;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShowRepository extends JpaRepository<Show, Long>{

    List<Show> findByShowType(String showType);

    Show findByName(String name);
}
