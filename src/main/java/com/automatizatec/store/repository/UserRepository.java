package com.automatizatec.store.repository;

import com.automatizatec.store.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {
    //@Query(nativeQuery = true, value = "select IdUsuario, IdPersonal, IdTipo, Clave, FlagActivo from Usuario where FlagActivo = 1")
    @Query(value = "select u from Usuario u where u.personal.personalId = :id and u.flagActive = true")
    List<UserEntity> findAllByPersonal(@Param("id") int personalId);
}
