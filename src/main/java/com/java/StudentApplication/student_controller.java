package com.java.StudentApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class student_controller {

    @Autowired
    student_repository studRepo;

    @Autowired
    examination_repository examRepo;

    @GetMapping("/findAll")
    public List<student> findAll() {
        List<student> s = studRepo.findAll();
        if (s.isEmpty()) System.out.println("Суденты не найдены");

        return s;
    }

    @GetMapping("/{id}/name")
    public String getNameById(@PathVariable Long id) {
        Optional<student> student = studRepo.findById(id);
        if (student.isPresent()) {
            return student.get().getName();
        } else {
            return "";
        }
    }

    @PostMapping("/update")
    public void update(student student) {
        studRepo.save(student);
    }

    @PostMapping("/advance")
    public void advanceToNextCourse(@RequestBody student student) {
        Integer totalExams = examRepo.getTotalCount();
        Integer passedExams = examRepo.getPassedCountByStudentId(student.id);
        if (student.isAllExamsPassed(totalExams, passedExams)) {
            student.course++;
            studRepo.save(student);
        }
    }
}
