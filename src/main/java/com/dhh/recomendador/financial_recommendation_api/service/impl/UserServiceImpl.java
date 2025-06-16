package com.dhh.recomendador.financial_recommendation_api.service.impl;

import com.dhh.recomendador.financial_recommendation_api.mapper.UserMapper;
import com.dhh.recomendador.financial_recommendation_api.model.User;
import com.dhh.recomendador.financial_recommendation_api.model.dto.UserDTO;
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
    private final UserMapper userMapper;


    @Override
    public UserDTO createUser(UserDTO userDTO) {
        log.info("Se guarda el usuario: {}", userDTO.toString());
        User entity = userMapper.toEntity(userDTO);
        User saved = userRepository.save(entity);
        return userMapper.toDto(saved);
    }

    @Override
    public UserDTO getUserById(UUID id) {
        log.info("Se busca el usuario con id: {}", id);
        return userRepository.findById(id).map(userMapper::toDto).orElseThrow();
    }

    @Override
    public List<UserDTO> getAllUsers() {
        log.info("Se buscan todos los usuarios");
        return userRepository.findAll().stream()
                .map(userMapper::toDto)
                .toList();
    }

    @Override
    public UserDTO updateUser(UUID id, UserDTO updatedUser) {
        log.info("Se actualiza el usuario con id: {}", id);
        return userRepository.findById(id)
                .map(existing -> {
                    User entity = userMapper.toEntity(updatedUser);
                    entity.setId(id);
                    return userRepository.save(entity);
                })
                .map(userMapper::toDto)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    @Override
    public void deleteUser(UUID id) {
        log.info("Se elimina el usuario con id: {}", id);
        userRepository.deleteById(id);
    }
}
