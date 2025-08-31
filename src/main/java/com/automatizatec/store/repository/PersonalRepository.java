package com.automatizatec.store.repository;

import com.automatizatec.store.entity.PersonalEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersonalRepository extends JpaRepository<PersonalEntity, Integer> {
    @Query("select p from Personal p where p.flagActive = true")
    List<PersonalEntity> findAllActives();

    @Query("SELECT p FROM Personal p " +
            "WHERE p.name LIKE CONCAT('%', :value, '%') " +
            "OR p.fatherLastName LIKE CONCAT('%', :value, '%') " +
            "OR p.motherLastName LIKE CONCAT('%', :value, '%')")
    List<PersonalEntity> search(@Param("value") String value);

    @Query("select p from Personal p where p.flagActive = true")
    Page<PersonalEntity> findAllCustomPaging(Pageable pageable);
}
