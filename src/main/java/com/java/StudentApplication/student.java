package com.java.StudentApplication;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student", schema = "ugly_code")
public class student {

    @Id
    @Column(name = "student_id")
    public Long id;

    @Column(name = "student_name")
    public String name;

    @Column(name = "phone_number")
    public Integer phoneNumber;

    @Column(name = "student_course")
    public Integer course;

    public boolean isAllExamsPassed(Integer totalExams, Integer passedExams) {
        if (totalExams == passedExams) {
            return true;
        } else {
            return false;
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getCourse() {
        return course;
    }

    public void setCourse(Integer course) {
        this.course = course;
    }
}
