package com.school.BOC.repository;

import com.school.BOC.model.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SchoolRepository extends JpaRepository<School, Long> {
    /**
     * Hibernate function to get School by student id
     * The request like in sql => SELECT * FROM SCHOOLS WHERE STUDENT_ID = 100
     *
     * @param studentId school owner id
     * @return school find by owner id
     */
    Optional<School> findByStudentId(long studentId);
}
