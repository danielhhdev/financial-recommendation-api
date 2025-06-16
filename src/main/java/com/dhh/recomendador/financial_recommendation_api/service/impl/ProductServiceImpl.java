package com.dhh.recomendador.financial_recommendation_api.service.impl;


import com.dhh.recomendador.financial_recommendation_api.mapper.ProductMapper;
import com.dhh.recomendador.financial_recommendation_api.model.Product;
import com.dhh.recomendador.financial_recommendation_api.model.dto.ProductDTO;
import com.dhh.recomendador.financial_recommendation_api.repository.ProductRepository;
import com.dhh.recomendador.financial_recommendation_api.service.EmbeddingService;
import com.dhh.recomendador.financial_recommendation_api.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final EmbeddingService embeddingService;

    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {
        log.info("Se guarda el producto: {}", productDTO.toString());
        Product entity = productMapper.toEntity(productDTO);
        Product saved = productRepository.save(entity);
        saved.setEmbedding(embeddingService.buildProductText(saved));
        return productMapper.toDto(saved);
    }

    @Override
    public Optional<ProductDTO> getProductById(UUID id) {
        log.info("Se busca el usuario con id: {}", id);
        return productRepository.findById(id).map(productMapper::toDto);
    }

    @Override

    public List<ProductDTO> getAllProducts() {
        log.info("Se buscan todos los usuarios");
        return productRepository.findAll().stream()
                .map(productMapper::toDto)
                .toList();
    }

    @Override
    public ProductDTO updateProduct(UUID id, ProductDTO updatedProduct) {
        log.info("Se actualiza el usuario con id: {}", id);
        return productRepository.findById(id)
                .map(existing -> {
                    Product entity = productMapper.toEntity(updatedProduct);
                    entity.setId(id);
                    entity.setEmbedding(embeddingService.buildProductText(entity));
                    return productRepository.save(entity);
                })
                .map(productMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
    }

    @Override
    public void deleteProduct(UUID id) {
        log.info("Se elimina el usuario con id: {}", id);
        productRepository.deleteById(id);
    }
}
