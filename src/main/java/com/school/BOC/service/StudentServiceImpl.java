package com.school.BOC.service;

import com.school.BOC.dto.model.StudentDto;
import com.school.BOC.dto.mapper.StudentMapper;
import com.school.BOC.model.Student;
import com.school.BOC.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("studentService")
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository studentRepository;

    @Override
    public Optional<Student> get(long studentId) {
        return studentRepository.findById(studentId);
    }

    @Override
    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> create(StudentDto studentDto) {
        return Optional.of( studentRepository.save(StudentMapper.toStudent(studentDto)));
    }

    @Override
    public String delete(long studentId) {
        studentRepository.deleteById(studentId);
        return "Student deleted with success";
    }

    @Override
    public Optional<Student> update(Student existingStudentToUpdate, StudentDto studentDtoWithUpdate) {
        // -- Update existing Student informations
        existingStudentToUpdate.setName(studentDtoWithUpdate.getName());
        existingStudentToUpdate.setGrade(studentDtoWithUpdate.getGrade());

        // -- Update existing Student in DB with new informations
        Optional<Student> updatedStudent = Optional.of(studentRepository.save(existingStudentToUpdate));

        return updatedStudent;
    }

}
