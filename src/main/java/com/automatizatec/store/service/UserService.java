package com.automatizatec.store.service;

import com.automatizatec.store.dto.UserPasswordRequestDTO;
import com.automatizatec.store.dto.UserRequestDTO;
import com.automatizatec.store.dto.UserResponseDTO;
import com.automatizatec.store.dto.UserSingleResponseDTO;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserResponseDTO> findAllByPersonal(int personalId) throws Exception;

    Optional<UserResponseDTO> findById(String userId) throws Exception;

    Optional<UserSingleResponseDTO> findSingleById(String userId) throws Exception;

    UserResponseDTO save(UserRequestDTO userRequestDTO) throws Exception;

    UserResponseDTO update(UserRequestDTO userRequestDTO) throws Exception;

    boolean updatePassword(UserPasswordRequestDTO userPasswordRequestDTO) throws Exception;

    void delete(String userId) throws Exception;
}
