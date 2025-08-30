package com.automatizatec.store.mapper;

import com.automatizatec.store.dto.UserRequestDTO;
import com.automatizatec.store.dto.UserResponseDTO;
import com.automatizatec.store.entity.UserEntity;

import java.util.List;

public interface UserMapper {
    UserResponseDTO toDTO(UserEntity entity);

    List<UserResponseDTO> toDTO(List<UserEntity> entities);

    UserEntity toEntity(UserRequestDTO dto);
}
