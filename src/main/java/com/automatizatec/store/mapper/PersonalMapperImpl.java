package com.automatizatec.store.mapper;

import com.automatizatec.store.dto.PersonalRequestDTO;
import com.automatizatec.store.dto.PersonalResponseDTO;
import com.automatizatec.store.entity.CompanyEntity;
import com.automatizatec.store.entity.PersonalDocumentEntity;
import com.automatizatec.store.entity.PersonalEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
public class PersonalMapperImpl implements PersonalMapper {
    @Override
    public PersonalResponseDTO toDTO(PersonalEntity entity) {
        return PersonalResponseDTO
                .builder()
                .personalId(entity.getPersonalId())
                .companyId(entity.getCompany().getCompanyId())
                .companyName(entity.getCompany().getCompanyName())
                .documentTypeId(entity.getDocumentType().getDocumentTypeId())
                .documentType(entity.getDocumentType().getDetail())
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

    @Override
    public PersonalEntity toEntity(PersonalRequestDTO dto) {
        CompanyEntity companyEntity = CompanyEntity
                .builder()
                .companyId(dto.getCompanyId())
                .build();

        PersonalDocumentEntity personalDocumentEntity = PersonalDocumentEntity
                .builder()
                .documentTypeId(dto.getDocumentTypeId())
                .build();

        return PersonalEntity
                .builder()
                .personalId(dto.getPersonalId())
                .company(companyEntity)
                .documentType(personalDocumentEntity)
                .documentNumber(dto.getDocumentNumber())
                .fatherLastName(dto.getFatherLastName())
                .motherLastName(dto.getMotherLastName())
                .name(dto.getName())
                .birthDate(dto.getBirthDate())
                .genre(dto.getGenre())
                .cellphone(dto.getCellphone())
                .email(dto.getEmail())
                .address(dto.getAddress())
                .dateAt(LocalDateTime.now())
                .personalRegisterId(dto.getPersonalRegisterId())
                .flagActive(dto.getFlagActive())
                .build();
    }

    @Override
    public Page<PersonalResponseDTO> toDTO(Pageable pageable, Page<PersonalEntity> pagePersonalEntity) {
        List<PersonalResponseDTO> lstPersonalRequestDTOs = pagePersonalEntity.getContent().stream().map(this::toDTO).toList();
        return new PageImpl<>(lstPersonalRequestDTOs, pageable, lstPersonalRequestDTOs.size());
    }
}
