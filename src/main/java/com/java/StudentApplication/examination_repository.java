package com.java.StudentApplication;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * Фиктивный репозиторий
 */
@Repository
public interface examination_repository extends JpaRepository<examination, Long> {

    @Query(nativeQuery = true, value = "SELECT 5")
    Integer getTotalCount();

    @Query(nativeQuery = true, value = "SELECT 5")
    Integer getPassedCountByStudentId(Long id);
}
