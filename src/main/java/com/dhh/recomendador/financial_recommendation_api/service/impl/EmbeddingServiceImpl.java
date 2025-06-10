package com.dhh.recomendador.financial_recommendation_api.service.impl;

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
    public List<Double> generateEmbedding(String text) {
        float[] embedding = embeddingModel.embed(List.of(text)).getFirst();
        List<Double> embeddingList = new ArrayList<>(embedding.length);
        for (float v : embedding) embeddingList.add((double) v);
        return embeddingList;
    }
}
