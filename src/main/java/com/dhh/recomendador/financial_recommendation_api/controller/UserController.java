package com.dhh.recomendador.financial_recommendation_api.controller;

import com.dhh.recomendador.financial_recommendation_api.model.User;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "User", description = "Operations for user management")
@RequestMapping("/api/users")
public interface UserController {

    @Operation(summary = "Create a new user", description = "Creates a user and returns it.")
    @PostMapping
    ResponseEntity<User> createUser(@RequestBody User user);

    @Operation(summary = "Get user by ID", description = "Retrieves a user by their UUID.")
    @GetMapping("/{id}")
    ResponseEntity<User> getUser(@PathVariable UUID id);

    @Operation(summary = "List all users", description = "Returns all users in the system.")
    @GetMapping
    ResponseEntity<List<User>> listUsers();

    @Operation(summary = "Update user", description = "Updates an existing user by ID.")
    @PutMapping("/{id}")
    ResponseEntity<User> updateUser(@PathVariable UUID id, @RequestBody User user);

    @Operation(summary = "Delete user", description = "Deletes a user by their UUID.")
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteUser(@PathVariable UUID id);
}
