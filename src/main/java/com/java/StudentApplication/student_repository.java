package com.java.StudentApplication;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface student_repository extends JpaRepository<student, Long> {
    List<student> findAll();

    Optional<student> findById(Long id);

    student save(student student);
}
