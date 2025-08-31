package com.automatizatec.store.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserSingleResponseDTO {
    private int companyId;
    private String company;
    private String userId;
    private int personalId;
    private String name;
    private String fatherLastName;
    private String motherLastName;
    private String fullName;
    private String email;
    private int userTypeId;
    private String userType;
    private String Password;
    private boolean flagActive;
}
