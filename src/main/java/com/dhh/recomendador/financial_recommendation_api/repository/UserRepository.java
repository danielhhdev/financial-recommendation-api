package com.dhh.recomendador.financial_recommendation_api.repository;

import com.dhh.recomendador.financial_recommendation_api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
}
