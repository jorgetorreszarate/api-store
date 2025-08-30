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
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "UsuarioTipo")
@Entity(name = "UsuarioTipo")
public class UserTypeEntity {

    @Id
    @Column(name = "IdTipo")
    private int typeId;

    @Column(name = "Detalle", length = 50, nullable = false)
    private String detail;
}
