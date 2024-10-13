package com.example.CRUDdemo.dao;

import com.example.CRUDdemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDaoImplementation implements StudentDao{
    //here we are using the EntityManager from the JPA Specification
    // not extending the JPARepository from the Spring Data JPA
    private EntityManager entityManager;

    @Autowired
    public StudentDaoImplementation(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    @Override
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student find(Integer studentId) {
        return entityManager.find(Student.class, studentId);
    }

    @Override
    public List<Student> findAllStudents() {
        TypedQuery<Student> theQuery = entityManager
                .createQuery("FROM Student ORDER BY last_name asc", Student.class);
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findStudentByLastName(String lastName) {
        TypedQuery<Student> theQuery = entityManager
                .createQuery("FROM Student WHERE last_name=:lName", Student.class);
        theQuery.setParameter("lName", lastName);
        return theQuery.getResultList();
    }

    @Transactional
    @Override
    public void updateStudent(Student student) {
        entityManager.merge(student);
    }

    @Transactional
    @Override
    public void deleteStudent(Integer id) {
        Student student = find(id);
        entityManager.remove(student);
    }

    @Transactional
    @Override
    public int deleteAllStudent() {
        int numRowsDeleted = entityManager.createQuery("DELETE FROM Student").executeUpdate();
        return numRowsDeleted;
    }
}
