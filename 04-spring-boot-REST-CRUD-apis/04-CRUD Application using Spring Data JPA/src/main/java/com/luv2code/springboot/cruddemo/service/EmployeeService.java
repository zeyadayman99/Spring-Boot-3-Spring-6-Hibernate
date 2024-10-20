package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.model.Employee;

import java.util.List;

public interface EmployeeService {
    //find employee by id
    Employee findEmployeeById(int id);

    //find all
    List<Employee> findAllEmployees();

    //update existing employee
    Employee updateEmployeeById(int id, Employee employee);

    //delete employee by id
    String deleteEmployeeById(int id);

    //save new employee
    Employee saveEmployee(Employee employee);
}
