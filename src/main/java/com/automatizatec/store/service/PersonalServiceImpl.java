package com.automatizatec.store.service;

import com.automatizatec.store.dto.PersonalResponseDTO;
import com.automatizatec.store.mapper.PersonalMapper;
import com.automatizatec.store.repository.PersonalRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
