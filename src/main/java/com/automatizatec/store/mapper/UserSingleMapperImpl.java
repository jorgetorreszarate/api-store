package com.automatizatec.store.mapper;

import com.automatizatec.store.dto.UserSingleResponseDTO;
import com.automatizatec.store.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserSingleMapperImpl implements UserSingleMapper {
    @Override
    public UserSingleResponseDTO toDTO(UserEntity entity) {
        return UserSingleResponseDTO
                .builder()
                .companyId(entity.getPersonal().getCompany().getCompanyId())
                .company(entity.getPersonal().getCompany().getCompanyName())
                .userId(entity.getUserId())
                .userTypeId(entity.getUserType().getTypeId())
                .personalId(entity.getPersonal().getPersonalId())
                .name(entity.getPersonal().getName())
                .fatherLastName(entity.getPersonal().getFatherLastName())
                .motherLastName(entity.getPersonal().getMotherLastName())
                .fullName(String.join(" ", entity.getPersonal().getName(), entity.getPersonal().getFatherLastName(), entity.getPersonal().getMotherLastName()))
                .email(entity.getPersonal().getEmail())
                .userType(entity.getUserType().getDetail())
                .Password(entity.getPassword())
                .flagActive(entity.isFlagActive())
                .build();
    }
}
