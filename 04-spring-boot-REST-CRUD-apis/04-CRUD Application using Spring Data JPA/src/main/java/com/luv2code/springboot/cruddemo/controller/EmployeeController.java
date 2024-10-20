package com.luv2code.springboot.cruddemo.controller;

import com.luv2code.springboot.cruddemo.model.Employee;
import com.luv2code.springboot.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    List<Employee> getAllEmployees() {
        return employeeService.findAllEmployees();
    }

    @GetMapping("/{id}")
    Employee getEmployeeById(@PathVariable("id") int id) {
        return employeeService.findEmployeeById(id);
    }

    @PostMapping
    Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @PutMapping
    Employee updateEmployee(@RequestBody Employee employee) {
        return employeeService.updateEmployeeById(employee.getId(), employee);
    }

    @DeleteMapping
    String deleteEmployee(@RequestBody Employee employee) {
        return employeeService.deleteEmployeeById(employee.getId());
    }
}
