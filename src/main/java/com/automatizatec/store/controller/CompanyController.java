package com.automatizatec.store.controller;

import com.automatizatec.store.dto.CompanyResponseDTO;
import com.automatizatec.store.service.CompanyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/companies")
public class CompanyController {
    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public ResponseEntity<List<CompanyResponseDTO>> getAll() throws Exception {
        List<CompanyResponseDTO> lstCompanies = companyService.getAll();
        return ResponseEntity.ok(lstCompanies);
    }
}
