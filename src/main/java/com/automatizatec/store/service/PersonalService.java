package com.automatizatec.store.service;

import com.automatizatec.store.dto.PersonalResponseDTO;

import java.util.List;

public interface PersonalService {
    List<PersonalResponseDTO> findAll() throws Exception;

    List<PersonalResponseDTO> search(String value) throws Exception;
}
