package com.automatizatec.store.mapper;

import com.automatizatec.store.dto.UserTypeResponseDTO;
import com.automatizatec.store.entity.UserTypeEntity;

import java.util.List;

public interface UserTypeMapper {
    UserTypeResponseDTO toDTO(UserTypeEntity entity);

    List<UserTypeResponseDTO> toDTO(List<UserTypeEntity> entities);
}
