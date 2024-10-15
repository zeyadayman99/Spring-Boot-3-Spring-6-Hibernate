package com.example.demo.customexception;

import com.example.demo.errorrespone.StudentNotFoundErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentExceptionHandler {

    @ExceptionHandler
    private ResponseEntity<StudentNotFoundErrorResponse> handleException(StudentNotFoundException e) {
        StudentNotFoundErrorResponse errorResponse = new StudentNotFoundErrorResponse();
        errorResponse.setMessage(e.getMessage());
        errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        errorResponse.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    private ResponseEntity<StudentNotFoundErrorResponse> handleException(Exception e) {
        StudentNotFoundErrorResponse errorResponse = new StudentNotFoundErrorResponse();
        errorResponse.setMessage("wrong entry!!");
        errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        errorResponse.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
