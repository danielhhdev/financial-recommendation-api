package com.dhh.recomendador.financial_recommendation_api.controller.impl;

import com.dhh.recomendador.financial_recommendation_api.controller.UserController;
import com.dhh.recomendador.financial_recommendation_api.model.dto.UserDTO;
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
    public ResponseEntity<UserDTO> createUser(UserDTO userDTO) {
        UserDTO created = userService.createUser(userDTO);
        return ResponseEntity.ok(created);
    }

    @Override
    public ResponseEntity<UserDTO> getUser(UUID id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @Override
    public ResponseEntity<List<UserDTO>> listUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @Override
    public ResponseEntity<UserDTO> updateUser(UUID id, UserDTO userDTO) {
        UserDTO updated = userService.updateUser(id, userDTO);
        return ResponseEntity.ok(updated);
    }

    @Override
    public ResponseEntity<Void> deleteUser(UUID id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
