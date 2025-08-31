package com.automatizatec.store.service;

import com.automatizatec.store.dto.UserTypeResponseDTO;
import com.automatizatec.store.entity.UserTypeEntity;
import com.automatizatec.store.mapper.UserTypeMapper;
import com.automatizatec.store.repository.UserTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserTypeServiceImpl implements UserTypeService {
    private final UserTypeRepository userTypeRepository;
    private final UserTypeMapper userTypeMapper;

    @Override
    public List<UserTypeResponseDTO> findAll() {
        List<UserTypeEntity> lstEntities = userTypeRepository.findAll();
        return userTypeMapper.toDTO(lstEntities);
    }

    @Override
    public Optional<UserTypeResponseDTO> findById(int id) {
        Optional<UserTypeEntity> userTypeEntity = userTypeRepository.findById(id);

        return userTypeEntity.map(userTypeMapper::toDTO);

    }
}
