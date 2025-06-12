package com.dhh.recomendador.financial_recommendation_api.model;

import com.dhh.recomendador.financial_recommendation_api.model.enumeration.ProductType;
import com.dhh.recomendador.financial_recommendation_api.model.enumeration.RiskLevel;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(length = 2000)
    private String description;

    @Enumerated(EnumType.STRING)
    private ProductType type; // Ej: CUENTA, TARJETA, PRESTAMO, FONDO, SEGURO

    private Double interestRate; // % anual

    private Double fees; // Comisiones

    private Double minAmount; // Importe mínimo

    private Double maxAmount; // Importe máximo

    @Column(length = 1000)
    private String eligibilityCriteria; // Requisitos (texto largo)

    @Enumerated(EnumType.STRING)
    private RiskLevel riskLevel;

    @ElementCollection
    private List<String> features; // Ventajas/Características

    @Column(columnDefinition = "TEXT")
    private String embedding;


}
