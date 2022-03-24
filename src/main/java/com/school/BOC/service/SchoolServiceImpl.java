package com.school.BOC.service;

import com.school.BOC.model.School;
import com.school.BOC.model.Student;
import com.school.BOC.repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("schoolService")
public class SchoolServiceImpl implements SchoolService{
    @Autowired
    SchoolRepository schoolRepository;

    @Override
    public Optional<School> get(long schoolId) {
        return schoolRepository.findById(schoolId);
    }

    @Override
    public List<School> getAll() {
        return schoolRepository.findAll();
    }

    @Override
    public Optional<School> create(String name, Student schoolOwner) {

        Optional<School> schoolExistWithOwnerId = getByOwnerId(schoolOwner.getId());

        if (schoolExistWithOwnerId.isPresent()){
            schoolExistWithOwnerId.get().setName(name);

            return Optional.of(schoolRepository.save(schoolExistWithOwnerId.get()));
        }

        School school = new School();
        school.setName(name);
        school.setStudent(schoolOwner);

        return Optional.of(schoolRepository.save(school));
    }

    @Override
    public Optional<School> getByOwnerId(long schoolOwnerId) {
        return schoolRepository.findByStudentId(schoolOwnerId);
    }
}
