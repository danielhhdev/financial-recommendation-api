package com.dhh.recomendador.financial_recommendation_api.controller;

import com.dhh.recomendador.financial_recommendation_api.model.dto.RecommendationDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.UUID;

@Tag(name = "Recomendaciones", description = "Endpoints para recomendaciones personalizadas de productos financieros")
@RequestMapping("/api/users")
public interface RecommendationController {

    @Operation(
            summary = "Obtener recomendaciones personalizadas",
            description = "Devuelve una lista de productos financieros recomendados para el usuario indicado",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Lista de recomendaciones generada correctamente"),
                    @ApiResponse(responseCode = "404", description = "Usuario no encontrado")
            }
    )
    ResponseEntity<List<RecommendationDTO>> getRecommendations(@PathVariable UUID userId);
}