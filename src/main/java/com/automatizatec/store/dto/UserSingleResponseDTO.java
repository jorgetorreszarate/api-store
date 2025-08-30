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
    private String userId;
    private int personalId;
    private String fullName;
    private int userTypeId;
    private String userType;
    private String Password;
    private boolean flagActive;
}
