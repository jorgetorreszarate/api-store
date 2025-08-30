package com.automatizatec.store.mapper;

import com.automatizatec.store.dto.PersonalResponseDTO;
import com.automatizatec.store.entity.PersonalEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class PersonalMapperImpl implements PersonalMapper {
    @Override
    public PersonalResponseDTO toDTO(PersonalEntity entity) {
        return PersonalResponseDTO
                .builder()
                .personalId(entity.getPersonalId())
                .companyId(entity.getCompanyId())
                .documentType(entity.getDocumentType())
                .documentNumber(entity.getDocumentNumber())
                .fatherLastName(entity.getFatherLastName())
                .motherLastName(entity.getMotherLastName())
                .name(entity.getName())
                .birthDate(entity.getBirthDate())
                .genre(entity.getGenre())
                .cellphone(entity.getCellphone())
                .email(entity.getEmail())
                .address(entity.getAddress())
                .flagActive(entity.getFlagActive())
                .build();
    }

    @Override
    public List<PersonalResponseDTO> toDTO(List<PersonalEntity> entities) {
        return entities.stream().map(this::toDTO).toList();
    }
}
