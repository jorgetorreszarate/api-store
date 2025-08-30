package com.automatizatec.store.dto;

import com.automatizatec.store.entity.PersonalDocumentEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PersonalResponseDTO {
    private int personalId;

    private int companyId;

    private PersonalDocumentEntity documentType;

    private String documentNumber;

    private String fatherLastName;

    private String motherLastName;

    private String name;

    private LocalDate birthDate;

    private String genre;

    private String cellphone;

    private String email;

    private String address;

    private Boolean flagActive;
}
