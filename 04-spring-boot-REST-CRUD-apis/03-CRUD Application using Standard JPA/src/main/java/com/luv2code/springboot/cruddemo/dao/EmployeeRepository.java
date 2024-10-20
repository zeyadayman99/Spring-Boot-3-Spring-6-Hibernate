package com.luv2code.springboot.cruddemo.dao;

import com.luv2code.springboot.cruddemo.model.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepository implements EmployeeDao{
    private final EntityManager entityManager;

    @Autowired
    public EmployeeRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Employee update(Employee employee) {
        Employee existingEmployee = entityManager.find(Employee.class, employee.getId());
        if (existingEmployee == null) {
            throw new EntityNotFoundException("Employee not found");
        }
        return entityManager.merge(employee);
    }


    @Override
    public Employee addEmployee(Employee employee) {
        Employee emp = entityManager.merge(employee);
        return emp;
    }

    @Override
    public List<Employee> getAllEmployees() {
        TypedQuery<Employee> query = entityManager.createQuery("from Employee", Employee.class);
        List<Employee> employees = query.getResultList();
        return employees;
    }

    @Override
    public Employee getEmployeeById(int id) {
        Employee employee = entityManager.find(Employee.class, id);
        return employee;
    }

    @Override
    public Employee getEmployeeByFname(String empFname) {
        TypedQuery<Employee> query = entityManager
                .createQuery("from Employee where first_name=:fName", Employee.class);
        Employee employee = query.setParameter("fName", empFname).getSingleResult();
        return employee;
    }

    @Override
    public boolean deleteEmployeeById(int id) {
        if (entityManager.contains(entityManager.find(Employee.class, id))) {
            entityManager.remove(entityManager.find(Employee.class, id));
            return true;
        }
        return false;
    }
}
