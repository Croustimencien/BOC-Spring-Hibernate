package com.school.BOC.controller;

import com.school.BOC.dto.model.CityDto;
import com.school.BOC.model.City;
import com.school.BOC.model.Student;
import com.school.BOC.service.CityService;
import com.school.BOC.service.StudentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/citys")
public class CityController {

    @Resource(name = "cityService")
    private CityService cityService;

    @Resource(name = "studentService")
    private StudentService studentService;

    @GetMapping("/{id}")
    public City get(@PathVariable long id) {
        return cityService.get(id).orElseThrow(() -> new RuntimeException("City not found : " + id));
    }

    @GetMapping
    public List<City> getAll() {
        return cityService.getAll();
    }

    @PostMapping
    public City create(final @RequestBody CityDto cityDto){
        Student cityOwner = studentService.get(CityDto.getCityOwnerId()).orElseThrow(() -> new RuntimeException("Student not found : " + cityDto.getCityOwnerId()));

        return cityService.create(cityDto.getNameCity(), cityOwner).orElseThrow(() -> new RuntimeException("Something went wrong, please try later"));
    }
}