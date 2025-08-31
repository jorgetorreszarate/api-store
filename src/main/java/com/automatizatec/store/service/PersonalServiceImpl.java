package com.automatizatec.store.service;

import com.automatizatec.store.dto.PersonalRequestDTO;
import com.automatizatec.store.dto.PersonalResponseDTO;
import com.automatizatec.store.entity.PersonalEntity;
import com.automatizatec.store.mapper.PersonalMapper;
import com.automatizatec.store.repository.PersonalRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonalServiceImpl implements PersonalService {
    private final PersonalRepository personalRepository;
    private final PersonalMapper personalMapper;

    public PersonalServiceImpl(PersonalRepository personalRepository, PersonalMapper personalMapper) {
        this.personalRepository = personalRepository;
        this.personalMapper = personalMapper;
    }

    @Override
    public List<PersonalResponseDTO> findAll() throws Exception {
        return personalMapper.toDTO(personalRepository.findAllActives());
    }

    @Override
    public List<PersonalResponseDTO> search(String value) throws Exception {
        return personalMapper.toDTO(personalRepository.search(value));
    }

    @Override
    public Page<PersonalResponseDTO> findAllCustomPagingEntity(Pageable pageable) throws Exception {
        return personalMapper.toDTO(pageable, personalRepository.findAllCustomPaging(pageable));
    }

    @Override
    public Optional<PersonalResponseDTO> findById(int personalId) throws Exception {
        Optional<PersonalEntity> personalEntity = personalRepository.findById(personalId);
        return personalEntity.map(personalMapper::toDTO);
    }

    @Override
    public int save(PersonalRequestDTO personalRequestDTO) throws Exception {
        PersonalEntity personalEntity = personalMapper.toEntity(personalRequestDTO);
        personalRepository.save(personalEntity);

        return personalEntity.getPersonalId();
    }

    @Override
    public boolean delete(int personalId) throws Exception {
        Optional<PersonalEntity> personalEntity = personalRepository.findById(personalId);

        if (personalEntity.isEmpty()) {
            return false;
        }

        PersonalEntity prmPersonalEntity = personalEntity.get();
        prmPersonalEntity.setFlagActive(false);

        personalRepository.save(prmPersonalEntity);

        return true;
    }
}
