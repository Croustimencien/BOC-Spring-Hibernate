package com.school.BOC.service;

import com.school.BOC.dto.model.StudentDto;
import com.school.BOC.model.Student;

import com.school.BOC.dto.model.StudentDto;
import com.school.BOC.model.Student;

import java.util.List;
import java.util.Optional;
public interface StudentService {
    /**
     * Get student by id
     *
     * @param studentId  student identifiant
     * @return student find by id
     */
    Optional<Student> get(long studentId);

    /**
     * Get list of student
     *
     * @return list of students
     */
    List<Student> getAll();

    /**
     * Create a new student
     *
     * @param studentDto to create
     * @return a new student created
     */
    Optional<Student> create(StudentDto studentDto);

    /**
     * Delete student by id
     *
     * @param studentId  student identifiant
     * @return delete student by id
     */
    String delete(long studentId);

    /**
     * Update a existing student
     *
     * @param existingStudentToUpdate existing student object
     * @param studentDtoWithUpdate student dto with informations to update
     * @return Student updated
     */
    Optional<Student> update(Student existingStudentToUpdate,StudentDto studentDtoWithUpdate);
}

