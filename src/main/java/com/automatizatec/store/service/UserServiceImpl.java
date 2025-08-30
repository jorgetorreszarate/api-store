package com.automatizatec.store.service;

import com.automatizatec.store.dto.UserPasswordRequestDTO;
import com.automatizatec.store.dto.UserRequestDTO;
import com.automatizatec.store.dto.UserResponseDTO;
import com.automatizatec.store.entity.UserEntity;
import com.automatizatec.store.entity.UserTypeEntity;
import com.automatizatec.store.mapper.UserMapper;
import com.automatizatec.store.repository.UserRepository;
import com.automatizatec.store.repository.UserTypeRepository;
import com.automatizatec.store.utils.PasswordEncoderUtil;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserTypeRepository userTypeRepository;
    private final UserMapper userMapper;
    private final PasswordEncoderUtil passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, UserTypeRepository userTypeRepository, UserMapper userMapper, PasswordEncoderUtil passwordEncoder) {
        this.userRepository = userRepository;
        this.userTypeRepository = userTypeRepository;
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
    public UserResponseDTO update(UserRequestDTO userRequestDTO) throws Exception {
        Optional<UserEntity> userEntity = userRepository.findById(userRequestDTO.getUserId());

        if (userEntity.isEmpty()) {
            return null;
        }

        UserEntity prmUserEntity = userEntity.get();

        // UserType
        Optional<UserTypeEntity> userTypeEntity = userTypeRepository.findById(userRequestDTO.getUserTypeId());

        if (userTypeEntity.isEmpty()) {
            throw new Exception("UserType not found");
        }

        prmUserEntity.setUserType(userTypeEntity.get());
        prmUserEntity.setFlagActive(userRequestDTO.isFlagActive());

        // Password
        String hashedPassword = passwordEncoder.encode(userRequestDTO.getPassword());
        prmUserEntity.setPassword(hashedPassword);

        return userMapper.toDTO(userRepository.save(prmUserEntity));
    }

    @Override
    public boolean updatePassword(UserPasswordRequestDTO userPasswordRequestDTO) throws Exception {
        Optional<UserEntity> userEntity = userRepository.findById(userPasswordRequestDTO.getUserId());

        // Usuario no existe
        if (userEntity.isEmpty()) {
            return false;
        }

        UserEntity prmUserEntity = userEntity.get();

        // Validar la contraseña anterior contra la que está en BD
        boolean isValid = passwordEncoder.verifyPassword(
                userPasswordRequestDTO.getOldPassword(),
                prmUserEntity.getPassword()
        );

        if (!isValid) {
            return false;
        }

        // Encriptar y actualizar nueva contraseña
        String hashedPassword = passwordEncoder.encode(userPasswordRequestDTO.getPassword());
        prmUserEntity.setPassword(hashedPassword);

        userRepository.save(prmUserEntity);
        return true;
    }

    @Override
    public void delete(String userId) throws Exception {
        Optional<UserEntity> userEntity = userRepository.findById(userId);

        if (userEntity.isEmpty()) {
            throw new Exception("User not found");
        }

        UserEntity prmUserEntity = userEntity.get();

        if (!prmUserEntity.isFlagActive()) {
            throw new Exception("User not is active");
        }

        prmUserEntity.setFlagActive(false);

        userRepository.save(prmUserEntity);
    }
}
