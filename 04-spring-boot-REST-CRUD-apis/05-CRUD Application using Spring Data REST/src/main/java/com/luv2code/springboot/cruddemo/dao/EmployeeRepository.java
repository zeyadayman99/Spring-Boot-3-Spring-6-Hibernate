package com.luv2code.springboot.cruddemo.dao;

import com.luv2code.springboot.cruddemo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;


@Repository
@RepositoryRestResource(path = "members")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    //No need to write any code, JPA Repository gives us CRUD methods out of the box
    //for free

}
