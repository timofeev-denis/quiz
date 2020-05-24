package com.java.StudentApplication;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class examination {

    @Id
    private Long id;

    private String subjectName;

}
