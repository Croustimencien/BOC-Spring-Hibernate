package com.school.BOC.repository;

import com.school.BOC.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
    /**
     * Hibernate function to get City by student id
     * The request like in sql => SELECT * FROM CITYS WHERE STUDENT_ID = 100
     *
     * @param studentId city owner id
     * @return City find by owner id
     */
    Optional<City> findByStudentId(long studentId);
}
