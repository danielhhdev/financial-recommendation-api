package com.dhh.recomendador.financial_recommendation_api.mapper;


import com.dhh.recomendador.financial_recommendation_api.model.User;
import com.dhh.recomendador.financial_recommendation_api.model.dto.UserDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO toDto(User user);
    User toEntity(UserDTO userDto);
}