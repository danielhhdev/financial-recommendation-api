package com.dhh.recomendador.financial_recommendation_api.service.impl;

import com.dhh.recomendador.financial_recommendation_api.model.dto.RecommendationDTO;
import com.dhh.recomendador.financial_recommendation_api.repository.ProductRepository;
import com.dhh.recomendador.financial_recommendation_api.repository.UserRepository;
import com.dhh.recomendador.financial_recommendation_api.service.EmbeddingService;
import com.dhh.recomendador.financial_recommendation_api.service.RecommendationService;
import com.dhh.recomendador.financial_recommendation_api.utils.EmbeddingUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.UUID;

import static com.dhh.recomendador.financial_recommendation_api.utils.EmbeddingUtils.buildReason;

@Service
@RequiredArgsConstructor
public class RecommendationServiceImpl implements RecommendationService {

    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final EmbeddingService embeddingService;

    @Override
    public List<RecommendationDTO> recommendProductsForUser(UUID userId) {
        // 1. Buscar usuario
        var userFound = userRepository.findById(userId).orElseThrow();
        // 2. Obtener/generar embedding usuario
        var embeddingUser = embeddingService.generateEmbedding(embeddingService.buildUserText(userFound));
        // 3. Recuperar productos y embeddings
        var listProduct = productRepository.findAll();
        // 4. Calcular similitudes
        // 5. Filtrar y ordenar
        // 6. Crear lista de RecommendationDTO
        // 7. Devolver lista

        return listProduct.stream()
                .filter(product -> product.getEmbedding() != null) // Solo productos con embedding generado
                .filter(product -> userFound.getExistingProducts() == null ||
                        !userFound.getExistingProducts().contains(product.getName())) // No recomendar productos ya contratados
                .map(product -> {
                    Double similarity = EmbeddingUtils.cosineSimilarity(embeddingUser, product.getEmbedding());
                    String reason = buildReason(product, userFound, similarity);
                    return RecommendationDTO.builder()
                            .productId(product.getId())
                            .productName(product.getName())
                            .similarity(similarity)
                            .reason(reason)
                            .build();
                })
                .sorted(Comparator.comparing(RecommendationDTO::getSimilarity).reversed()) // Ordenar por similitud descendente
                .limit(5) // Top N recomendaciones
                .toList();

    }
}
