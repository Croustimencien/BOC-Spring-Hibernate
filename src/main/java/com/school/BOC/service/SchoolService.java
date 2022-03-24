package com.school.BOC.service;

import com.school.BOC.model.School;
import com.school.BOC.model.Student;

import java.util.List;
import java.util.Optional;

public interface SchoolService {
    Optional<School> get(long schoolId);
    List<School> getAll();
    Optional<School> create(String name, Student schoolOwner);
    Optional<School> getByOwnerId(long schoolOwnerId);
}
