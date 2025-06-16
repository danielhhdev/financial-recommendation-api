package com.dhh.recomendador.financial_recommendation_api.controller.impl;

import com.dhh.recomendador.financial_recommendation_api.controller.RecommendationController;
import com.dhh.recomendador.financial_recommendation_api.model.dto.RecommendationDTO;
import com.dhh.recomendador.financial_recommendation_api.service.RecommendationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class RecommendationControllerImpl implements RecommendationController {

    private final RecommendationService recommendationService;

    @Override
    @GetMapping("/{userId}/recommendations")
    public ResponseEntity<List<RecommendationDTO>> getRecommendations(UUID userId) {
        List<RecommendationDTO> recommendations = recommendationService.recommendProductsForUser(userId);
        return ResponseEntity.ok(recommendations);
    }
}
