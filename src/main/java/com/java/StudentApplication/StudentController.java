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

    @GetMapping("/findAll")
    public List<Student> findAll() {
        List<Student> s = studRepo.findAll();
        if (s.isEmpty()) System.out.println("Суденты не найдены");

        return s;
    }

    @GetMapping("/{id}/name")
    public String getNameById(@PathVariable Long id) {
        Optional<Student> student = studRepo.findById(id);
        if (student.isPresent()) {
            return student.get().getName();
        } else {
            return "";
        }
    }

    @PostMapping("/update")
    public void update(Student student) {
        studRepo.save(student);
    }

    @PostMapping("/advance")
    public void advanceToNextCourse(@RequestBody Student student) {
        Integer totalExams = examRepo.getTotalCount();
        if (student.getPassedExams() == totalExams) {
            student.course++;
            studRepo.save(student);
        }
    }
}
