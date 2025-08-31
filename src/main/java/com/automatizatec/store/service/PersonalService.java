package com.automatizatec.store.service;

import com.automatizatec.store.dto.PersonalRequestDTO;
import com.automatizatec.store.dto.PersonalResponseDTO;

import java.util.List;
import java.util.Optional;

public interface PersonalService {
    List<PersonalResponseDTO> findAll() throws Exception;

    List<PersonalResponseDTO> search(String value) throws Exception;

    Optional<PersonalResponseDTO> findById(int personalId) throws Exception;

    int save(PersonalRequestDTO personalRequestDTO) throws Exception;

    boolean delete(int personalId) throws Exception;
}
