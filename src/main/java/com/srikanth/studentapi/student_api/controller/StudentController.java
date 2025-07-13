package com.srikanth.studentapi.student_api.controller;

import com.srikanth.studentapi.student_api.exception.StudentNotFoundException;
import com.srikanth.studentapi.student_api.model.Student;
import com.srikanth.studentapi.student_api.repository.StudentRepository;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students_api")
public class StudentController {
    @Autowired
    private StudentRepository studentrepo;

    @PostMapping()
    public ResponseEntity<Student> addStudent(@RequestBody Student student){
        Student s = studentrepo.save(student);
        return ResponseEntity.ok(s);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id){
        Student s = studentrepo.findById(id).orElseThrow(() -> new StudentNotFoundException("Student not found with id "+id));
        return ResponseEntity.ok(s);
    }

    @GetMapping()
    public ResponseEntity<List<Student>> getAllStudents(){
        List<Student> list = studentrepo.findAll();
        return ResponseEntity.ok(list);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student student){
        Student s = studentrepo.findById(id).orElseThrow(() -> new StudentNotFoundException("Student not found with id "+id));
        s.setName(student.getName());
        s.setEmail(student.getEmail());
        s.setAge(student.getAge());
        Student stu = studentrepo.save(s);
        return ResponseEntity.ok(stu);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudentById(@PathVariable Long id){
        Student student = studentrepo.findById(id).orElseThrow(() -> new StudentNotFoundException("Student not found with id "+id));
        studentrepo.delete(student);
        return ResponseEntity.ok("Student deleted successfully");
    }
    @GetMapping("/Name")
    public ResponseEntity<List<Student>> getStudentByName(@RequestParam String name){
        List<Student> list = studentrepo.findAllByName(name);
        return ResponseEntity.ok(list);
    }
}
