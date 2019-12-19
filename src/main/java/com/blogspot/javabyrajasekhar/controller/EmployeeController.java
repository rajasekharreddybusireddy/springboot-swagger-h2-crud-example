package com.blogspot.javabyrajasekhar.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogspot.javabyrajasekhar.model.Employee;
import com.blogspot.javabyrajasekhar.repository.EmployeeRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeController {

	@Autowired
	EmployeeRepository employeeRepository;

	@GetMapping("/allemployees")
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();

	}

	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable(name = "id") Integer id) {

		Optional<Employee> optional = employeeRepository.findById(id);

		if (optional.isPresent()) {
			Employee employee = employeeRepository.getOne(id);
			return new ResponseEntity<>(employee, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);

	}

	@PostMapping("/save")
	public List<Employee> saveEmployee(@RequestBody Employee employee) {
		employeeRepository.save(employee);
		return employeeRepository.findAll();

	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteById(@PathVariable Integer id) {
		try {
			employeeRepository.deleteById(id);
		} catch (Exception e) {
			return new ResponseEntity<String>("employee not found", HttpStatus.NOT_FOUND);

		}
		return new ResponseEntity<String>("employee is deleted", HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
		Optional<Employee> optional = employeeRepository.findById(employee.getEno());
		if (optional.isPresent()) {
			Employee employee2 = optional.get();
			employee2.setName(employee.getName());
			employee2.setSalary(employee.getSalary());
			employeeRepository.save(employee2);
			return new ResponseEntity<Employee>(optional.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<Employee>(HttpStatus.EXPECTATION_FAILED);
		}

	}
}
