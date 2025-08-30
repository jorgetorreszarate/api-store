package com.automatizatec.store.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserPasswordRequestDTO {
    private String userId;
    private String oldPassword;
    private String password;
}
