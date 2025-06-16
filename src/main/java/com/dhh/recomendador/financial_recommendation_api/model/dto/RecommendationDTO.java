package com.dhh.recomendador.financial_recommendation_api.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RecommendationDTO {

    private UUID productId;

    private String productName;

    private Double similarity;

    private String reason; // Opcional: explicar la recomendación
}