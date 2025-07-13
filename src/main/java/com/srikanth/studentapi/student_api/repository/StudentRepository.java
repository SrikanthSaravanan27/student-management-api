package com.srikanth.studentapi.student_api.repository;

import com.srikanth.studentapi.student_api.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Long> {

    @Query("SELECT s FROM Student s WHERE s.name=:name")
    public List<Student> findAllByName(@Param("name") String name);
}
