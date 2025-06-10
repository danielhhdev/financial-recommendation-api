package com.dhh.recomendador.financial_recommendation_api.controller;

import com.dhh.recomendador.financial_recommendation_api.model.Product;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "Product", description = "Operations for product management")
@RequestMapping("/api/products")
public interface ProductController {

    @Operation(summary = "Create a new product", description = "Creates a product and returns it.")
    @PostMapping
    ResponseEntity<Product> createProduct(@RequestBody Product product);

    @Operation(summary = "Get product by ID", description = "Retrieves a product by its UUID.")
    @GetMapping("/{id}")
    ResponseEntity<Product> getProduct(@PathVariable UUID id);

    @Operation(summary = "List all products", description = "Returns all products in the system.")
    @GetMapping
    ResponseEntity<List<Product>> listProducts();

    @Operation(summary = "Update product", description = "Updates an existing product by ID.")
    @PutMapping("/{id}")
    ResponseEntity<Product> updateProduct(@PathVariable UUID id, @RequestBody Product product);

    @Operation(summary = "Delete product", description = "Deletes a product by its UUID.")
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteProduct(@PathVariable UUID id);
}