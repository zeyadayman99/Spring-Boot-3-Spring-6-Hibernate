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
    public List<Employee> getEmployees() {
        return employeeService.findAll();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable("id") int id) {
        return employeeService.findEmployeeById(id);
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }
    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable int id) {
        Employee employee = employeeService.findEmployeeById(id);
        if (employee == null) {
            throw new RuntimeException("Employee with id " + id + " not found");
        }
        employeeService.deleteEmployee(id);
        return "Employee with id " + id + " deleted";
    }
    @PutMapping
    public Employee updateEmployee(@RequestBody Employee employee) {
        return employeeService.updateEmployee(employee);
    }

}
