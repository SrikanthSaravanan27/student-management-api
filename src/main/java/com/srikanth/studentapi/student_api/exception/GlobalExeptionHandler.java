package com.srikanth.studentapi.student_api.exception;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExeptionHandler {
    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<Map<String,Object>> handleStudentNotFoundException(StudentNotFoundException exception, HttpServletRequest request) {
        Map<String,Object> response = new LinkedHashMap<>();
        response.put("timestamp", LocalDateTime.now());
        response.put("status",HttpStatus.NOT_FOUND);
        response.put("error","Student not found");
        response.put("message",exception.getMessage());
        response.put("path",request.getRequestURI());
        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    }
}
