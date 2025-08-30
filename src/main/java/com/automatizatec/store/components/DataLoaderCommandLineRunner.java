package com.automatizatec.store.components;

import com.automatizatec.store.dto.UserRequestDTO;
import com.automatizatec.store.entity.UserEntity;
import com.automatizatec.store.mapper.UserMapper;
import com.automatizatec.store.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoaderCommandLineRunner implements CommandLineRunner {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    public DataLoaderCommandLineRunner(UserRepository userRepository, UserMapper userMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("run DataLoader CommandLineRunner...");
        registerUserAdmin(1);
    }

    private void registerUserAdmin(int personalId) {
        String adminId = "ADMIN";
        String password = "123";

        if (userRepository.findById(adminId).isPresent()) {
            return;
        }

        try {
            UserRequestDTO userRequestDTO = new UserRequestDTO();
            userRequestDTO.setUserId(adminId);
            userRequestDTO.setPersonalId(personalId);
            userRequestDTO.setUserTypeId(1);
            userRequestDTO.setPassword(passwordEncoder.encode(password));

            UserEntity userEntity = userMapper.toEntity(userRequestDTO);
            userRepository.save(userEntity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
