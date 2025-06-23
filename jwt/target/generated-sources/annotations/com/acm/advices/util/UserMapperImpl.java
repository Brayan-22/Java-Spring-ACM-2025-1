package com.acm.advices.util;

import com.acm.advices.controller.dto.UserDTO;
import com.acm.advices.model.User;
import com.acm.advices.persistence.entity.UserEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-06-22T22:42:48-0500",
    comments = "version: 1.6.3, compiler: javac, environment: Java 23 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User entityToModel(UserEntity userEntity) {
        if ( userEntity == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.id( userEntity.getId() );
        user.username( userEntity.getUsername() );
        user.password( userEntity.getPassword() );
        user.email( userEntity.getEmail() );

        return user.build();
    }

    @Override
    public UserEntity modelToEntity(User user) {
        if ( user == null ) {
            return null;
        }

        UserEntity.UserEntityBuilder userEntity = UserEntity.builder();

        userEntity.id( user.getId() );
        userEntity.username( user.getUsername() );
        userEntity.password( user.getPassword() );
        userEntity.email( user.getEmail() );

        return userEntity.build();
    }

    @Override
    public User dtoToModel(UserDTO userDto) {
        if ( userDto == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.username( userDto.getUsername() );
        user.password( userDto.getPassword() );
        user.email( userDto.getEmail() );

        return user.build();
    }

    @Override
    public UserDTO modelToDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDTO.UserDTOBuilder userDTO = UserDTO.builder();

        userDTO.username( user.getUsername() );
        userDTO.password( user.getPassword() );
        userDTO.email( user.getEmail() );

        return userDTO.build();
    }
}
