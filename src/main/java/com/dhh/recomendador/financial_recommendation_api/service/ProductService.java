package com.dhh.recomendador.financial_recommendation_api.service;

import com.dhh.recomendador.financial_recommendation_api.model.Product;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductService {

    Product createProduct(Product product);
    Optional<Product> getProductById(UUID id);
    List<Product> getAllProducts();
    Product updateProduct(UUID id, Product product);
    void deleteProduct(UUID id);
}
