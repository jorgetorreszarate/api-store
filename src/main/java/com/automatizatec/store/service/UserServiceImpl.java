package com.automatizatec.store.service;

import com.automatizatec.store.dto.UserResponseDTO;
import com.automatizatec.store.entity.UserEntity;
import com.automatizatec.store.mapper.UserMapper;
import com.automatizatec.store.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public List<UserResponseDTO> findAll() throws Exception {
        return userMapper.toDTO(userRepository.findAllCustom());
    }

    @Override
    public Optional<UserResponseDTO> findById(String userId) throws Exception {
        Optional<UserEntity> userEntity = userRepository.findById(userId);

        if (userEntity.isEmpty()) {
            throw new Exception("El usuario no existe");
        }

        return Optional.ofNullable(userMapper.toDTO(userEntity.get()));
    }
}
