package com.dhh.recomendador.financial_recommendation_api.controller.impl;

import com.dhh.recomendador.financial_recommendation_api.controller.ProductController;
import com.dhh.recomendador.financial_recommendation_api.model.Product;
import com.dhh.recomendador.financial_recommendation_api.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class ProductControllerImpl implements ProductController {

    private final ProductService productService;


    @Override
    public ResponseEntity<Product> createProduct(Product product) {
        Product created = productService.createProduct(product);
        return ResponseEntity.ok(created);
    }

    @Override
    public ResponseEntity<Product> getProduct(UUID id) {
        return productService.getProductById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<List<Product>> listProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @Override
    public ResponseEntity<Product> updateProduct(UUID id, Product product) {
        Product updated = productService.updateProduct(id, product);
        return ResponseEntity.ok(updated);
    }

    @Override
    public ResponseEntity<Void> deleteProduct(UUID id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}