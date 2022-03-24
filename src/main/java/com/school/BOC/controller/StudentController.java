package com.school.BOC.controller;

import com.school.BOC.dto.model.StudentDto;
import com.school.BOC.model.Student;
import com.school.BOC.service.StudentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Resource(name = "studentService")
    private StudentService studentService;

    @GetMapping("/{id}") //Key  GET + /students/id
    public Student get(@PathVariable long id) {
        return studentService.get(id).orElseThrow(() -> new RuntimeException("Student not found : " + id));
    }

    @GetMapping //Key GET + /students/
    public List<Student> getAll() {
        return studentService.getAll();
    }

    @PostMapping // Key POST + /students/
    public Student create(final @RequestBody StudentDto student){
        return studentService.create(student).orElseThrow(() -> new RuntimeException("Something went wrong, please try later"));
    }

    @PutMapping("/{id}")
    public Student update(@PathVariable long id, final @RequestBody StudentDto studentDtoWithUpdate) {
        Optional<Student> existingStudentToUpdate = Optional.ofNullable(studentService.get(id).orElseThrow(() -> new RuntimeException("Student not found : " + id)));

        return studentService.update(existingStudentToUpdate.get(), studentDtoWithUpdate)
                .orElseThrow(() -> new RuntimeException("Something went wrong, please try later"));
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable long id) {
        return studentService.delete(id);
    }

}