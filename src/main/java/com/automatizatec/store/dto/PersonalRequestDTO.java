package com.automatizatec.store.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PersonalRequestDTO {
    private int personalId;
    private int companyId;
    private  String companyName;
    private int documentTypeId;
    private String documentType;
    private String documentNumber;
    private String fatherLastName;
    private String motherLastName;
    private String name;
    private LocalDate birthDate;
    private String genre;
    private String cellphone;
    private String email;
    private String address;
    private int personalRegisterId;
    private Boolean flagActive;
}
