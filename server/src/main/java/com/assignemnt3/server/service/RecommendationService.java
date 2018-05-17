package com.assignemnt3.server.service;

import com.assignemnt3.server.model.Recommendation;
import com.assignemnt3.server.repository.RecommendationRepository;
import com.assignemnt3.server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecommendationService {

    @Autowired
    private RecommendationRepository recommendationRepository;

    @Autowired
    private UserRepository userRepository;

    public void addRecommendation(Recommendation recommendation) {
        recommendation.setSecondUserId(userRepository.findByUsername(recommendation.getSecondUserUsername()).getUserId());
        recommendationRepository.save(recommendation);
    }

    public List<Recommendation> getAllRecommendations() {
        return  recommendationRepository.findAll();
    }

    public List<Recommendation> getAllRecommendations(Long secondUserId) {
        List<Recommendation> recommendationList = recommendationRepository.findBySecondUserId(secondUserId);
        return recommendationList;
    }

    public List<Recommendation> getAllRecommendationsYouHaveSent(Long firstUserId) {
        List<Recommendation> recommendationList = recommendationRepository.findByFirstUserId(firstUserId);
        return recommendationList;
    }
}
