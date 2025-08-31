package com.automatizatec.store.service;

import com.automatizatec.store.dto.CompanyResponseDTO;
import com.automatizatec.store.entity.CompanyEntity;
import com.automatizatec.store.mapper.CompanyMapper;
import com.automatizatec.store.repository.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository companyRepository;
    private final CompanyMapper companyMapper;

    public CompanyServiceImpl(CompanyRepository companyRepository, CompanyMapper companyMapper) {
        this.companyRepository = companyRepository;
        this.companyMapper = companyMapper;
    }

    @Override
    public List<CompanyResponseDTO> getAll() {
        List<CompanyEntity> lstCompanies = companyRepository.findAll();
        return companyMapper.toDTO(lstCompanies);
    }
}
