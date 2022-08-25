package com.example.devadmin_technical_task.model.repository;

import com.example.devadmin_technical_task.model.entity.MockEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

public interface DatabaseRepository extends JpaRepository<MockEntity, Integer> {
    @Modifying
    @Transactional
    String query(String queryString);
}
