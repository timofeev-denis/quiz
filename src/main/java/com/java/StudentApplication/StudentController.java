package com.java.StudentApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    Student_repository studRepo;

    @Autowired
    Examination_repository examRepo;

    @GetMapping("/FindAll")
    public List<Student> findAll() {
        List<Student> s = studRepo.findAll();
        if (s.isEmpty()) System.out.println("Суденты не найдены");

        return s;
    }

    @GetMapping("/{id}")
    public Student getById(@PathVariable Long id) {
        Optional<Student> student = studRepo.findById(id);
        if (student.isPresent()) {
            return student.get();
        } else {
            return null;
        }
    }

    @PostMapping("/update")
    public void update(Student student) {
        // Если студент сдал все экзамены, то переводим его на следующий курс
        Integer totalExams = examRepo.getTotalCount(); // Получаем количество всех существующих экзаменов
        if (student.getPassedExams() == totalExams) {
            student.course++;
        }
        studRepo.save(student);
    }

    @PutMapping("/create")
    public void create(Student student) {
        studRepo.save(student);
    }

}
