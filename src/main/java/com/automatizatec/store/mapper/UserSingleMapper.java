package com.automatizatec.store.mapper;

import com.automatizatec.store.dto.UserSingleResponseDTO;
import com.automatizatec.store.entity.UserEntity;

public interface UserSingleMapper {
    UserSingleResponseDTO toDTO(UserEntity entity);
}
