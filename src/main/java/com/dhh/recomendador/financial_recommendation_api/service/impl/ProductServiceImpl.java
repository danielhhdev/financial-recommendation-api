package com.dhh.recomendador.financial_recommendation_api.service.impl;


import com.dhh.recomendador.financial_recommendation_api.model.Product;
import com.dhh.recomendador.financial_recommendation_api.repository.ProductRepository;
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

    @Override
    public Product createProduct(Product product) {
        log.info("Se guarda el producto: {}", product.toString());
        return productRepository.save(product);
    }

    @Override
    public Optional<Product> getProductById(UUID id) {
        log.info("Se busca el usuario con id: {}", id);
        return productRepository.findById(id);
    }

    @Override
    public List<Product> getAllProducts() { 
        log.info("Se buscan todos los usuarios");
        return productRepository.findAll();
    }

    @Override
    public Product updateProduct(UUID id, Product updatedProduct) {
        log.info("Se actualiza el usuario con id: {}", id);
        return productRepository.findById(id)
                .map(existingProduct -> {
                    existingProduct.setName(updatedProduct.getName());
                    existingProduct.setDescription(updatedProduct.getDescription());
                    // ... otros campos si los hay
                    return productRepository.save(existingProduct);
                })
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
    }

    @Override
    public void deleteProduct(UUID id) {
        log.info("Se elimina el usuario con id: {}", id);
        productRepository.deleteById(id);
    }
}
