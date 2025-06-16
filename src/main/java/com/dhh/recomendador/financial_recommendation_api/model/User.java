package com.dhh.recomendador.financial_recommendation_api.model;

import com.dhh.recomendador.financial_recommendation_api.model.enumeration.MaritalStatus;
import com.dhh.recomendador.financial_recommendation_api.model.enumeration.RiskProfile;
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
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    private Integer age; // Edad

    private String occupation; // Profesión

    private Double income; // Ingresos mensuales o anuales

    @Enumerated(EnumType.STRING)
    private MaritalStatus maritalStatus; // Estado civil

    private Integer numberOfDependents; // Número de dependientes

    @ElementCollection
    private List<String> financialGoals; // Ej: ["ahorrar", "comprar casa", "invertir"]

    @Enumerated(EnumType.STRING)
    private RiskProfile riskProfile; // Perfil de riesgo

    @ElementCollection
    private List<String> existingProducts; // Productos financieros actuales

}
