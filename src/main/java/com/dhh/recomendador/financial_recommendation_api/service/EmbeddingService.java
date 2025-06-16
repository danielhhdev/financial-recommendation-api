package com.dhh.recomendador.financial_recommendation_api.service;

import com.dhh.recomendador.financial_recommendation_api.model.Product;
import com.dhh.recomendador.financial_recommendation_api.model.User;

import java.util.List;

public interface EmbeddingService {

    public Double[] generateEmbedding(String text);
    String buildProductText(Product product);
    String buildUserText(User user);
}
