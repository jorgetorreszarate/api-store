package com.automatizatec.store.mapper;

import com.automatizatec.store.dto.CompanyResponseDTO;
import com.automatizatec.store.entity.CompanyEntity;

import java.util.List;

public interface CompanyMapper {
    CompanyResponseDTO toDTO(CompanyEntity entity);

    List<CompanyResponseDTO> toDTO(List<CompanyEntity> entities);
}
