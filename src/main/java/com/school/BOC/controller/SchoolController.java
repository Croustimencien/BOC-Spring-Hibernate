package com.school.BOC.controller;

import com.school.BOC.dto.model.SchoolDto;
import com.school.BOC.model.School;
import com.school.BOC.model.Student;
import com.school.BOC.service.SchoolService;
import com.school.BOC.service.StudentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

    @RestController
    @RequestMapping("/schools")
    public class SchoolController {

        @Resource(name = "schoolService")
        private SchoolService schoolService;

        @Resource(name = "studentService")
        private StudentService studentService;

        @GetMapping("/{id}")
        public School get(@PathVariable long id) {
            return schoolService.get(id).orElseThrow(() -> new RuntimeException("School not found : " + id));
        }

        @GetMapping
        public List<School> getAll() {
            return schoolService.getAll();
        }

        @PostMapping
        public School create(final @RequestBody SchoolDto schoolDto){
            Student schoolOwner = studentService.get(SchoolDto.getSchoolOwnerId()).orElseThrow(() -> new RuntimeException("Student not found : " + schoolDto.getSchoolOwnerId()));

            return schoolService.create(schoolDto.getName(), schoolOwner).orElseThrow(() -> new RuntimeException("Something went wrong, please try later"));
        }
    }