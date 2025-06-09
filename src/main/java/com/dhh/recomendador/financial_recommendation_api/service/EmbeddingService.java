package com.dhh.recomendador.financial_recommendation_api.service;

import java.util.List;

public interface EmbeddingService {

    public List<Double> generateEmbedding(String text);
}
