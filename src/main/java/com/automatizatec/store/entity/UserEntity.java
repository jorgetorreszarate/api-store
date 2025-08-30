package com.automatizatec.store.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "Usuario")
@Entity(name = "Usuario")
public class UserEntity {
    @Id
    @Column(name = "IdUsuario", length = 80)
    private String userId;

    @ManyToOne
    @JoinColumn(name = "IdPersonal", nullable = false)
    private PersonalEntity personal;

    @Column(name = "Clave", length = 250, nullable = false)
    private String password;

    @ManyToOne
    @JoinColumn(name = "IdTipo", nullable = false)
    private UserTypeEntity userType;

    @Column(name = "FlagActivo", nullable = false)
    private boolean flagActive;
}
