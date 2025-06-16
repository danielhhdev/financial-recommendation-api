package com.dhh.recomendador.financial_recommendation_api.config;

import com.dhh.recomendador.financial_recommendation_api.repository.ProductRepository;
import com.dhh.recomendador.financial_recommendation_api.service.EmbeddingService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductEmbeddingInitializer implements ApplicationRunner {

    private final ProductRepository productRepository;
    private final EmbeddingService embeddingService;

    @Override
    public void run(ApplicationArguments args) {
        var listProduct = productRepository.findAll();

        listProduct.stream()
                .filter(product -> product.getEmbedding() == null)
                .forEach(product -> {
                    product.setEmbedding(embeddingService.generateEmbedding(embeddingService.buildProductText(product)));
                    productRepository.save(product);
                });
    }
}