package com.prasadch.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.prasadch.model.Employee;
import com.prasadch.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}

	@PostMapping
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
		return new ResponseEntity<Employee>(employeeService.saveemployee(employee), HttpStatus.CREATED);

	}

	@GetMapping
	public List<Employee> getallemployees() {
		return employeeService.getallemployees();

	}

	@RequestMapping("{id}")
	public ResponseEntity<Employee> getemployeeById(@PathVariable("id") long Id) {
		return new ResponseEntity<Employee>(employeeService.getemployeeById(Id), HttpStatus.OK);
	}

	@PutMapping("{id}")
	public ResponseEntity<Employee> updateemployeebyid(@PathVariable("id") long id, @RequestBody Employee employee) {
		return new ResponseEntity<Employee>(employeeService.updateemployeebyid(employee, id), HttpStatus.OK);

	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteemployee(@PathVariable("id") long id) {
		employeeService.deleteemployee(id);
		return new ResponseEntity<String>("Record deleted Successfully", HttpStatus.OK);

	}

}
