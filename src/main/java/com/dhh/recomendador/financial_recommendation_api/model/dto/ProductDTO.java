package com.dhh.recomendador.financial_recommendation_api.model.dto;

import com.dhh.recomendador.financial_recommendation_api.model.enumeration.ProductType;
import com.dhh.recomendador.financial_recommendation_api.model.enumeration.RiskLevel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDTO {

    private UUID id;

    @NotBlank(message = "Product name is mandatory")
    private String name;

    @NotBlank(message = "Description is mandatory")
    @Size(max = 2000, message = "Description is too long")
    private String description;

    @NotNull(message = "Product type is mandatory")
    private ProductType type;

    @PositiveOrZero(message = "Interest rate must be zero or positive")
    private Double interestRate;

    @PositiveOrZero(message = "Fees must be zero or positive")
    private Double fees;

    @PositiveOrZero(message = "Minimum amount must be zero or positive")
    private Double minAmount;

    @PositiveOrZero(message = "Maximum amount must be zero or positive")
    private Double maxAmount;

    @Size(max = 1000, message = "Eligibility criteria is too long")
    private String eligibilityCriteria;

    private RiskLevel riskLevel;

    private List<@NotBlank String> features;

}