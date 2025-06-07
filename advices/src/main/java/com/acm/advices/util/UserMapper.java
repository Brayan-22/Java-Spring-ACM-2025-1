package com.acm.advices.util;

import com.acm.advices.controller.dto.UserDTO;
import com.acm.advices.model.User;
import com.acm.advices.persistence.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {
    // ENTITY -> MODEL
    User entityToModel(UserEntity userEntity);
    // MODEL -> ENTITY
    UserEntity modelToEntity(User user);


    // DTO -> MODEL
    User dtoToModel(UserDTO userDto);
    // MODELO -> DTO

    UserDTO modelToDto(User user);
}
