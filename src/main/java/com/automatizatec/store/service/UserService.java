package com.automatizatec.store.service;

import com.automatizatec.store.dto.UserRequestDTO;
import com.automatizatec.store.dto.UserResponseDTO;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserResponseDTO> findAll() throws Exception;

    Optional<UserResponseDTO> findById(String userId) throws Exception;

    UserResponseDTO save(UserRequestDTO userRequestDTO) throws Exception;

    boolean verifyPassword(String rawPassword, String encodedPassword);
}
