package com.blogspot.javabyrajasekhar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.blogspot.javabyrajasekhar.model.Employee;
import com.blogspot.javabyrajasekhar.repository.EmployeeRepository;

@SpringBootApplication
public class SpringbootH2JpaRestCrudExampleApplication implements CommandLineRunner{

	@Autowired
	EmployeeRepository employeeRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringbootH2JpaRestCrudExampleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	employeeRepository.save(new Employee(1,"rajasekhar",7000d));
	employeeRepository.save(new Employee(2,"vamsi",6045d));	
	employeeRepository.save(new Employee(3,"srinu",5432d));	
	employeeRepository.save(new Employee(4,"vasu",8634d));	
	employeeRepository.save(new Employee(5,"anil",1235d));	
	}
}
