package com.dhh.recomendador.financial_recommendation_api.service;

import com.dhh.recomendador.financial_recommendation_api.model.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserService {

    User createUser(User user);

    Optional<User> getUserById(UUID id);

    List<User> getAllUsers();

    User updateUser(UUID id, User user);

    void deleteUser(UUID id);
}
