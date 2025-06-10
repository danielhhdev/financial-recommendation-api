package com.dhh.recomendador.financial_recommendation_api.repository;

import com.dhh.recomendador.financial_recommendation_api.model.Recommendation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RecomendationRepository extends JpaRepository<Recommendation, UUID> {
}
