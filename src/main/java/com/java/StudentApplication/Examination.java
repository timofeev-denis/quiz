package com.java.StudentApplication;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Examination {

    @Id
    private Long id;

    private String subjectName;

}
