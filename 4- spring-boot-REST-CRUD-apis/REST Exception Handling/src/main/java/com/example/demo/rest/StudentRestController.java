package com.example.demo.rest;

import com.example.demo.customexception.StudentNotFoundException;
import com.example.demo.entity.Student;
import com.example.demo.errorrespone.StudentNotFoundErrorResponse;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private List<Student> studentList;

    @PostConstruct
    public void loadData() {
        studentList = new ArrayList<>();
        studentList.add(new Student(1, "ahmed", "mohamed", true));
        studentList.add(new Student(2, "mariam", "ahmed", true));
        studentList.add(new Student(3, "maged", "abdallah", true));
    }

    @GetMapping("/students")
    List<Student> getStudentList() {
        return studentList;
    }

    @GetMapping("/students/{studentId}")
    Student getStudent(@PathVariable int studentId) {
        if (studentId < 1 || studentId >= studentList.size()) {
            throw new StudentNotFoundException("Student with id = " + studentId + " not found");
        }
        return studentList.get(studentId);
    }

    //this is an exception handler to handle if student id is not within th range
    @ExceptionHandler
    private ResponseEntity<StudentNotFoundErrorResponse> handleException(StudentNotFoundException e) {
        StudentNotFoundErrorResponse errorResponse = new StudentNotFoundErrorResponse();
        errorResponse.setMessage(e.getMessage());
        errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        errorResponse.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    //making a generic exception handler to handle all exceptions(Catch all)
    //like if user entered a string instead of id
    @ExceptionHandler
    private ResponseEntity<StudentNotFoundErrorResponse> handleException(Exception e) {
        StudentNotFoundErrorResponse errorResponse = new StudentNotFoundErrorResponse();
        errorResponse.setMessage("wrong entry!!");
        errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        errorResponse.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
