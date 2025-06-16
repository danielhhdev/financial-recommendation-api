package com.dhh.recomendador.financial_recommendation_api.service;

import com.dhh.recomendador.financial_recommendation_api.model.Product;

import java.util.List;

public interface EmbeddingService {

    public List<Double> generateEmbedding(String text);
    String buildProductText(Product product);
}
