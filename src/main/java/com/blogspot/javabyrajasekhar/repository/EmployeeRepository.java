package com.blogspot.javabyrajasekhar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogspot.javabyrajasekhar.model.Employee;

public interface EmployeeRepository  extends JpaRepository<Employee, Integer>{

}
