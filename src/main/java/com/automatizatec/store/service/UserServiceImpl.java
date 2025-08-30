package com.automatizatec.store.service;

import com.automatizatec.store.dto.UserRequestDTO;
import com.automatizatec.store.dto.UserResponseDTO;
import com.automatizatec.store.entity.UserEntity;
import com.automatizatec.store.mapper.UserMapper;
import com.automatizatec.store.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<UserResponseDTO> findAll() throws Exception {
        return userMapper.toDTO(userRepository.findAllCustom());
    }

    @Override
    public Optional<UserResponseDTO> findById(String userId) throws Exception {
        Optional<UserEntity> userEntity = userRepository.findById(userId);

        return userEntity.map(userMapper::toDTO);
    }

    @Override
    public UserResponseDTO save(UserRequestDTO userRequestDTO) throws Exception {
        // Hash password
        String hashedPassword = passwordEncoder.encode(userRequestDTO.getPassword());
        userRequestDTO.setPassword(hashedPassword);

        UserEntity userEntity = userMapper.toEntity(userRequestDTO);
        UserEntity resUserEntity = userRepository.save(userEntity);
        return userMapper.toDTO(resUserEntity);
    }

    @Override
    public boolean verifyPassword(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }
}
