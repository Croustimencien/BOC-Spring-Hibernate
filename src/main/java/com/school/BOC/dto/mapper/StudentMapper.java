package com.school.BOC.dto.mapper;

import com.school.BOC.dto.model.StudentDto;
import com.school.BOC.model.Student;

import java.util.Date;

public class StudentMapper {
    public static Student toStudent(StudentDto studentDto) {
        Student student = new Student();
        student.setName(studentDto.getName());
        student.setGrade(studentDto.getGrade());
        student.setBirth(studentDto.getBirth());

        return student;
    }
}
