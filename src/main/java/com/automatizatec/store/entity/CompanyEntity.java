package com.automatizatec.store.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "Empresa")
@Entity(name = "Empresa")
public class CompanyEntity {
    @Id
    @Column(name = "IdEmpresa")
    private int companyId;

    @Column(name = "IdTipoDocumento", nullable = false)
    private int documentTypeId;

    @Column(name = "NroDocumento", length = 15, nullable = false)
    private String documentNumber;

    @Column(name = "RazonSocial", length = 100, nullable = false)
    private String companyName;

    @Column(name = "NombreComercial", length = 100)
    private String tradeName;

    @Column(name = "FlagActivo", nullable = false)
    private boolean flagActive;
}
