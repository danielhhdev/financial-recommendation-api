package com.dhh.recomendador.financial_recommendation_api.model.dto;

import com.dhh.recomendador.financial_recommendation_api.model.enumeration.MaritalStatus;
import com.dhh.recomendador.financial_recommendation_api.model.enumeration.RiskProfile;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
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
public class UserDTO {

    private UUID id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @Email(message = "Email should be valid")
    @NotBlank(message = "Email is mandatory")
    private String email;

    @Min(value = 18, message = "Minimum age is 18")
    @Max(value = 120, message = "Maximum age is 120")
    private Integer age;

    private String occupation;

    @PositiveOrZero(message = "Income must be zero or positive")
    private Double income;

    private MaritalStatus maritalStatus;

    @Min(value = 0, message = "Number of dependents must be zero or greater")
    private Integer numberOfDependents;

    private List<@NotBlank String> financialGoals;

    private RiskProfile riskProfile;

    private List<@NotBlank String> existingProducts;

}
