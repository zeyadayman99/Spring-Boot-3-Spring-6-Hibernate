package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.dao.EmployeeDao;
import com.luv2code.springboot.cruddemo.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final  EmployeeDao employeeDao;

    @Autowired
    public EmployeeServiceImpl(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }
    @Override
    public List<Employee> findAll() {
        return employeeDao.getAllEmployees();
    }

    @Override
    public Employee findEmployeeById(int id) {
        return employeeDao.getEmployeeById(id);
    }

    @Override
    public Employee findEmployeeByFname(String fname) {
        return employeeDao.getEmployeeByFname(fname);
    }

    @Transactional
    @Override
    public Employee updateEmployee(Employee employee) {
        Employee emp = employeeDao.update(employee);
        return emp;
    }

    @Transactional
    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeDao.addEmployee(employee);
    }

    @Transactional
    @Override
    public boolean deleteEmployee(int id) {
        if (employeeDao.deleteEmployeeById(id))
            return true;
        return false;
    }
}
