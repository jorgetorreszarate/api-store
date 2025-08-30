package com.automatizatec.store.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "Personal")
@Entity(name = "Personal")
public class PersonalEntity {

    @Id
    @Column(name = "IdPersonal")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int personalId;

    @Column(name = "IdEmpresa", nullable = false)
    private int companyId;

    @ManyToOne
    @JoinColumn(name = "IdTipoDocumento", nullable = false)
    private PersonalDocumentEntity documentType;

    @Column(name = "NroDocumento", length = 30, nullable = false)
    private String documentNumber;

    @Column(name = "ApePaterno", length = 250, nullable = false)
    private String fatherLastName;

    @Column(name = "ApeMaterno", length = 250, nullable = false)
    private String motherLastName;

    @Column(name = "Nombres", length = 250, nullable = false)
    private String name;

    @Column(name = "FechaNacimiento")
    private LocalDate birthDate;

    @Column(name = "Genero", columnDefinition = "CHAR(1)")
    private String genre;

    @Column(name = "Celular", length = 50)
    private String cellphone;

    @Column(name = "Email", length = 80)
    private String email;

    @Column(name = "Direccion", length = 250)
    private String address;

    @Column(name = "FechaRegistro", nullable = false)
    private LocalDateTime dateAt;

    @Column(name = "IdPersonalRegistro")
    private int personalRegisterId;

    @Column(name = "FlagActivo", nullable = false)
    private Boolean flagActive;
}
