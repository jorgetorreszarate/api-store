package com.automatizatec.store.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserResponseDTO {
    private String userId;
    private int personalId;
    private String fullName;
    private String password;
    private int userTypeId;
    private String userType;
    private boolean flagActive;
}
