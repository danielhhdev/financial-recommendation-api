package com.dhh.recomendador.financial_recommendation_api.service.impl;

import com.dhh.recomendador.financial_recommendation_api.model.Product;
import com.dhh.recomendador.financial_recommendation_api.model.User;
import com.dhh.recomendador.financial_recommendation_api.service.EmbeddingService;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmbeddingServiceImpl implements EmbeddingService {

    private final EmbeddingModel embeddingModel;


    @Override
    public Double[] generateEmbedding(String text) {
        float[] embedding = embeddingModel.embed(List.of(text)).getFirst();
        Double[] embeddingArray = new Double[embedding.length];
        for (int i = 0; i < embedding.length; i++) {
            embeddingArray[i] = (double) embedding[i];
        }
        return embeddingArray;
    }

    public String buildProductText(Product product) {
        StringBuilder sb = new StringBuilder();
        sb.append(product.getName()).append(". ");
        if (product.getDescription() != null) sb.append(product.getDescription()).append(". ");
        if (product.getType() != null) sb.append("Tipo: ").append(product.getType().toString()).append(". ");
        if (product.getInterestRate() != null) sb.append("Interés: ").append(product.getInterestRate()).append("%. ");
        if (product.getFees() != null) sb.append("Comisiones: ").append(product.getFees()).append(". ");
        if (product.getEligibilityCriteria() != null) sb.append("Requisitos: ").append(product.getEligibilityCriteria()).append(". ");
        if (product.getRiskLevel() != null) sb.append("Riesgo: ").append(product.getRiskLevel().toString()).append(". ");
        if (product.getFeatures() != null && !product.getFeatures().isEmpty())
            sb.append("Características: ").append(String.join(", ", product.getFeatures())).append(". ");
        return sb.toString();
    }

    public String buildUserText(User user) {
        StringBuilder sb = new StringBuilder();
        sb.append(user.getName()).append(". ");
        if (user.getAge() != null) sb.append("Edad: ").append(user.getAge()).append(". ");
        if (user.getOccupation() != null) sb.append("Profesión: ").append(user.getOccupation()).append(". ");
        if (user.getIncome() != null) sb.append("Ingresos: ").append(user.getIncome()).append(". ");
        if (user.getMaritalStatus() != null) sb.append("Estado civil: ").append(user.getMaritalStatus().toString()).append(". ");
        if (user.getNumberOfDependents() != null) sb.append("Dependientes: ").append(user.getNumberOfDependents()).append(". ");
        if (user.getFinancialGoals() != null && !user.getFinancialGoals().isEmpty())
            sb.append("Objetivos: ").append(String.join(", ", user.getFinancialGoals())).append(". ");
        if (user.getRiskProfile() != null) sb.append("Perfil de riesgo: ").append(user.getRiskProfile().toString()).append(". ");
        if (user.getExistingProducts() != null && !user.getExistingProducts().isEmpty())
            sb.append("Productos contratados: ").append(String.join(", ", user.getExistingProducts())).append(". ");
        return sb.toString();
    }
}
