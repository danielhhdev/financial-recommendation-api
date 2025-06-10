package com.dhh.recomendador.financial_recommendation_api.controller.impl;

import com.dhh.recomendador.financial_recommendation_api.controller.UserController;
import com.dhh.recomendador.financial_recommendation_api.model.User;
import com.dhh.recomendador.financial_recommendation_api.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class UserControllerImpl implements UserController {

    private final UserService userService;


    @Override
    public ResponseEntity<User> createUser(User user) {
        User created = userService.createUser(user);
        return ResponseEntity.ok(created);
    }

    @Override
    public ResponseEntity<User> getUser(UUID id) {
        return userService.getUserById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<List<User>> listUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @Override
    public ResponseEntity<User> updateUser(UUID id, User user) {
        User updated = userService.updateUser(id, user);
        return ResponseEntity.ok(updated);
    }

    @Override
    public ResponseEntity<Void> deleteUser(UUID id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
