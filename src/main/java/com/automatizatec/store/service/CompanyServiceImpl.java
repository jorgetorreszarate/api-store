package com.automatizatec.store.service;

import com.automatizatec.store.dto.CompanyResponseDTO;
import com.automatizatec.store.entity.CompanyEntity;
import com.automatizatec.store.mapper.CompanyMapper;
import com.automatizatec.store.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository companyRepository;
    private final CompanyMapper companyMapper;

    @Override
    public List<CompanyResponseDTO> getAll() {
        List<CompanyEntity> lstCompanies = companyRepository.findAll();
        return companyMapper.toDTO(lstCompanies);
    }
}
