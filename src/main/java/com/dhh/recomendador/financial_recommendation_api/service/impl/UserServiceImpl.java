package com.dhh.recomendador.financial_recommendation_api.service.impl;

import com.dhh.recomendador.financial_recommendation_api.model.User;
import com.dhh.recomendador.financial_recommendation_api.repository.UserRepository;
import com.dhh.recomendador.financial_recommendation_api.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;


    @Override
    public User createUser(User user) {
        log.info("Se guarda el usuario: {}", user.toString());
        // Si necesitas validación extra, agrégala aquí
        return userRepository.save(user);
    }

    @Override
    public Optional<User> getUserById(UUID id) {
        log.info("Se busca el usuario con id: {}", id);
        return userRepository.findById(id);
    }

    @Override
    public List<User> getAllUsers() {
        log.info("Se buscan todos los usuarios");
        return userRepository.findAll();
    }

    @Override
    public User updateUser(UUID id, User updatedUser) {
        log.info("Se actualiza el usuario con id: {}", id);
        return userRepository.findById(id)
                .map(existingUser -> {
                    existingUser.setName(updatedUser.getName());
                    existingUser.setEmail(updatedUser.getEmail());
                    // ... cualquier otro campo que permita actualización
                    return userRepository.save(existingUser);
                })
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    @Override
    public void deleteUser(UUID id) {
        log.info("Se elimina el usuario con id: {}", id);
        userRepository.deleteById(id);
    }
}
