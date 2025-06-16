package com.dhh.recomendador.financial_recommendation_api.service;

import com.dhh.recomendador.financial_recommendation_api.model.dto.UserDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserService {

    UserDTO createUser(UserDTO user);

    UserDTO getUserById(UUID id);

    List<UserDTO> getAllUsers();

    UserDTO updateUser(UUID id, UserDTO user);

    void deleteUser(UUID id);
}
