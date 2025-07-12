package com.srikanth.studentapi.student_api.controller;

import com.srikanth.studentapi.student_api.model.Student;
import com.srikanth.studentapi.student_api.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students_api")
public class StudentController {
    @Autowired
    private StudentRepository studentrepo;

    @PostMapping()
    public void addStudent(@RequestBody Student student){
        studentrepo.save(student);
    }

    @GetMapping("{id}")
    public Student getStudentById(@PathVariable String id){
        return studentrepo.findById(id).get();
    }

    @GetMapping()
    public List<Student> getAllStudents(){
        return studentrepo.findAll();
    }
}
