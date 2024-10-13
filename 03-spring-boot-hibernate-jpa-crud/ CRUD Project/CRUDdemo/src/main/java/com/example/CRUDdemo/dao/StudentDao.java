package com.example.CRUDdemo.dao;

import com.example.CRUDdemo.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentDao {
    void save(Student student);
    Student find(Integer studentId);
    List<Student> findAllStudents();
    List<Student> findStudentByLastName(String lastName);
    void updateStudent(Student student);
    void deleteStudent(Integer id);
    int deleteAllStudent();
}
