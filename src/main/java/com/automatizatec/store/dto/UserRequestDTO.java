package com.automatizatec.store.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserRequestDTO {
    private String userId;
    private int personalId;
    private String password;
    private int userTypeId;
    private boolean flagActive;
}
