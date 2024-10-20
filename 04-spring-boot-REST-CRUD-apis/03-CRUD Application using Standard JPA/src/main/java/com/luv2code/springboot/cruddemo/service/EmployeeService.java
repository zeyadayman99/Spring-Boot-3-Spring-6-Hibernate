package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {
    List<Employee> findAll();
    Employee findEmployeeById(int id);
    Employee findEmployeeByFname(String fname);
    Employee updateEmployee(Employee employee);
    Employee saveEmployee(Employee employee);
    boolean deleteEmployee(int id);
}
