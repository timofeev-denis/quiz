package com.java.StudentApplication;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Фиктивный репозиторий
 */
@Repository
public interface Examination_repository extends JpaRepository<Examination, Long> {

    @Query(nativeQuery = true, value = "SELECT 5")
    Integer getTotalCount();

    @Query(nativeQuery = true, value = "SELECT 5")
    Integer getPassedCountByStudentId(Long id);
}
