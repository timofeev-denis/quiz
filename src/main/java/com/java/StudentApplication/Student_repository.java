package com.java.StudentApplication;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface Student_repository extends JpaRepository<Student, Long> {
    List<Student> findAll();

    Optional<Student> findById(Long id);

    Student save(Student student);
}
