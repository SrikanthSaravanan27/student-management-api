package com.srikanth.studentapi.student_api.repository;

import com.srikanth.studentapi.student_api.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,String> {
}
