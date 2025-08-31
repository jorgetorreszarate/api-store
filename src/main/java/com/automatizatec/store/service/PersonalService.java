package com.automatizatec.store.service;

import com.automatizatec.store.dto.PersonalRequestDTO;
import com.automatizatec.store.dto.PersonalResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface PersonalService {
    List<PersonalResponseDTO> findAll() throws Exception;

    List<PersonalResponseDTO> search(String value) throws Exception;

    Page<PersonalResponseDTO> findAllCustomPagingEntity(Pageable pageable) throws Exception;

    Optional<PersonalResponseDTO> findById(int personalId) throws Exception;

    int save(PersonalRequestDTO personalRequestDTO) throws Exception;

    boolean delete(int personalId) throws Exception;
}
