package com.srikanth.studentapi.student_api.exception;

public class StudentNotFoundException extends RuntimeException{
    public StudentNotFoundException(String msg){
        super(msg);
    }
}
