package com.automatizatec.store.mapper;

import com.automatizatec.store.dto.UserTypeResponseDTO;
import com.automatizatec.store.entity.UserTypeEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UserTypeMapperImpl implements UserTypeMapper {
    @Override
    public UserTypeResponseDTO toDTO(UserTypeEntity entity) {
        return UserTypeResponseDTO
                .builder()
                .typeId(entity.getTypeId())
                .detail(entity.getDetail())
                .build();
    }

    @Override
    public List<UserTypeResponseDTO> toDTO(List<UserTypeEntity> entities) {
        return entities.stream().map(this::toDTO).toList();
    }
}
