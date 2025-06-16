package com.dhh.recomendador.financial_recommendation_api.service;

import com.dhh.recomendador.financial_recommendation_api.model.dto.ProductDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductService {

    ProductDTO createProduct(ProductDTO product);
    Optional<ProductDTO> getProductById(UUID id);
    List<ProductDTO> getAllProducts();
    ProductDTO updateProduct(UUID id, ProductDTO product);
    void deleteProduct(UUID id);
}
