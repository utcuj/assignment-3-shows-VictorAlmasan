package com.assignemnt3.server.repository;

import com.assignemnt3.server.model.Recommendation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecommendationRepository extends JpaRepository<Recommendation, Long> {

    List<Recommendation> findBySecondUserId(Long secondUserId);

    List<Recommendation> findByFirstUserId(Long firstUserId);
}
