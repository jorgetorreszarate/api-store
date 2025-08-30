package com.automatizatec.store.repository;

import com.automatizatec.store.entity.PersonalEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonalRepository extends JpaRepository<PersonalEntity, Integer> {
}
