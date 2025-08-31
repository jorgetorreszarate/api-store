package com.automatizatec.store.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CompanyResponseDTO {
    private int companyId;
    private int documentTypeId;
    private String documentNumber;
    private String companyName;
    private String tradeName;
    private boolean flagActive;
}
