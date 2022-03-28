package com.school.BOC.service;

import com.school.BOC.model.City;
import com.school.BOC.model.Student;

import java.util.List;
import java.util.Optional;

public interface CityService {
    Optional<City> get(long cityId);
    List<City> getAll();
    Optional<City> create(String nameCity, Student cityOwner);
    Optional<City> getByOwnerId(long cityOwnerId);
}
