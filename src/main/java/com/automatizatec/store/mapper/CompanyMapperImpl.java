package com.automatizatec.store.mapper;

import com.automatizatec.store.dto.CompanyResponseDTO;
import com.automatizatec.store.entity.CompanyEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CompanyMapperImpl implements CompanyMapper {

    @Override
    public CompanyResponseDTO toDTO(CompanyEntity entity) {
        return CompanyResponseDTO
                .builder()
                .companyId(entity.getCompanyId())
                .documentTypeId(entity.getDocumentTypeId())
                .documentNumber(entity.getDocumentNumber())
                .companyName(entity.getCompanyName())
                .tradeName(entity.getTradeName())
                .flagActive(entity.isFlagActive())
                .build();
    }

    @Override
    public List<CompanyResponseDTO> toDTO(List<CompanyEntity> entities) {
        return entities.stream().map(this::toDTO).toList();
    }
}
