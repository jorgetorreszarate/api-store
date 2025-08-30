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
@Table(name = "PersonalDocumento")
@Entity(name = "PersonalDocumento")
public class PersonalDocumentEntity {
    @Id
    @Column(name = "IdTipoDocumento")
    private int documentTypeId;

    @Column(name = "Detalle", length = 250, nullable = false)
    private String detail;
}
