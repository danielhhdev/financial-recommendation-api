package com.dhh.recomendador.financial_recommendation_api.service;

import com.dhh.recomendador.financial_recommendation_api.model.dto.RecommendationDTO;

import java.util.List;
import java.util.UUID;

public interface RecommendationService {
    List<RecommendationDTO> recommendProductsForUser(UUID userId);
}

