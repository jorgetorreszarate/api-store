package com.automatizatec.store.mapper;

import com.automatizatec.store.dto.PersonalRequestDTO;
import com.automatizatec.store.dto.PersonalResponseDTO;
import com.automatizatec.store.entity.PersonalEntity;

import java.util.List;

public interface PersonalMapper {
    PersonalResponseDTO toDTO(PersonalEntity entity);

    List<PersonalResponseDTO> toDTO(List<PersonalEntity> entities);

    PersonalEntity toEntity(PersonalRequestDTO dto);
}
