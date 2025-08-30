package com.automatizatec.store.service;

import com.automatizatec.store.dto.UserResponseDTO;
import com.automatizatec.store.entity.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserResponseDTO> findAll() throws Exception;
    Optional<UserResponseDTO> findById(String userId) throws Exception;
}
