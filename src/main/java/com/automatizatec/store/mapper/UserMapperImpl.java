package com.automatizatec.store.mapper;

import com.automatizatec.store.dto.UserRequestDTO;
import com.automatizatec.store.dto.UserResponseDTO;
import com.automatizatec.store.entity.PersonalEntity;
import com.automatizatec.store.entity.UserEntity;
import com.automatizatec.store.entity.UserTypeEntity;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UserMapperImpl implements UserMapper {

    private final ModelMapper modelMapper;

    @PostConstruct
    public void setup() {
        // Entity → DTO
        modelMapper.addMappings(new PropertyMap<UserEntity, UserResponseDTO>() {
            @Override
            protected void configure() {
                //PersonalEntity personal = source.getPersonal();
                //UserTypeEntity userType = source.getUserType();

                map().setPersonalId(source.getPersonal().getPersonalId());
                //map().setFullName(personal.getName() + " " + personal.getFatherLastName() + " " + personal.getMotherLastName());
                String fullName = source.getPersonal().getName();
                map().setFullName(fullName);

                map().setUserTypeId(source.getUserType().getTypeId());
                map().setUserType(source.getUserType().getDetail());
            }
        });

        // DTO → Entity (crea objetos cascarón con solo ID)
        modelMapper.addMappings(new PropertyMap<UserResponseDTO, UserEntity>() {
            @Override
            protected void configure() {
                map().getPersonal().setPersonalId(source.getPersonalId());
                map().getUserType().setTypeId(source.getUserTypeId());
            }
        });
    }

    @Override
    public UserResponseDTO toDTO(UserEntity entity) {
        return modelMapper.map(entity, UserResponseDTO.class);
    }

    @Override
    public List<UserResponseDTO> toDTO(List<UserEntity> entities) {
        return entities.stream().map(this::toDTO).toList();
    }

    @Override
    public UserEntity toEntity(UserRequestDTO dto) {
        return modelMapper.map(dto, UserEntity.class);
    }
}
