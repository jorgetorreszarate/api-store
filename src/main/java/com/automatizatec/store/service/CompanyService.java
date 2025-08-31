package com.automatizatec.store.service;

import com.automatizatec.store.dto.CompanyResponseDTO;

import java.util.List;

public interface CompanyService {
    List<CompanyResponseDTO> getAll() throws Exception;
}
