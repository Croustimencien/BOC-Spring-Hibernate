package com.school.BOC.model;

import javax.persistence.*;

@Entity // To specify our class as table in DB
@Table(name = "students") // To customize table name

public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name; // Name of the student.

    private String Birth; // When he/she born.

    @Enumerated(EnumType.STRING) // To specify we want get our enum in string
    private Grade grade; // What grade he/she is.

    @OneToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "student")
    private School school; // What type of school (Learn It, Sup de Com', etc..).

    public Student() {
    }

    public Student(long id, String name, Grade grade, String school, String birth) {
        this.id = id;
        this.name = name;
        this.Birth = birth;
    } // Constructor of the class

    // Getter and Setter of the class
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirth() {
        return Birth;
    }

    public void setBirth(String birth) {
        Birth = birth;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

}