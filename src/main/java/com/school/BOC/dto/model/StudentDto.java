package com.school.BOC.dto.model;

import com.school.BOC.model.Grade;

public class StudentDto {

    private String name;

    private String school;

    private Grade grade;

    private String birth;

    public StudentDto(String name, String school, Grade grade, String birth) {
        this.name = name;
        this.school = school;
        this.grade = grade;
        this.birth = birth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

}