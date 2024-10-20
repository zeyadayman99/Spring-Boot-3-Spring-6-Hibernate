package com.luv2code.springboot.cruddemo.dao;

import com.luv2code.springboot.cruddemo.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeDao {
    //update existing employee
    Employee update(Employee employee);
    //returns employee id
    Employee addEmployee(Employee employee);
    //get all employees
    List<Employee> getAllEmployees();
    //get employee by id
    Employee getEmployeeById(int id);
    //get employee by first name
    Employee getEmployeeByFname(String empFname);
    //delete employee
    boolean deleteEmployeeById(int id);

}
