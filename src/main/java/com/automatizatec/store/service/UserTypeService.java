package com.automatizatec.store.service;

import com.automatizatec.store.dto.UserTypeResponseDTO;

import java.util.List;
import java.util.Optional;

public interface UserTypeService {
    List<UserTypeResponseDTO> findAll();

    Optional<UserTypeResponseDTO> findById(int id);
}
