package com.automatizatec.store.repository;

import com.automatizatec.store.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {
    //@Query(nativeQuery = true, value = "select IdUsuario, IdPersonal, IdTipo, Clave, FlagActivo from Usuario where FlagActivo = 1")
    @Query("select u from Usuario u where u.personal.personalId = :id and u.flagActive = true")
    List<UserEntity> findAllByPersonal(@Param("id") int personalId);

    @Query("select u from Usuario u where u.userId = :userId and u.flagActive = true and u.personal.flagActive = true")
    Optional<UserEntity> findSingleByUserId(@Param("userId") String userId);
}
