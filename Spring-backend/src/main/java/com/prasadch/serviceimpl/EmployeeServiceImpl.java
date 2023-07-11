package com.prasadch.serviceimpl;

import java.util.List;
import org.springframework.stereotype.Service;

import com.prasadch.exception.ResourceNotFound;
import com.prasadch.model.Employee;
import com.prasadch.repository.EmployeeRepository;
import com.prasadch.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeRepository employeeRepository;

	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	@Override
	public Employee saveemployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getallemployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee getemployeeById(long id) {
		return employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Emplyee", "Id", id));
	}
	@Override
	public Employee updateemployeebyid(Employee employee, long id) {
		Employee existingemployee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFound("Emplyee", "Id", id));
		existingemployee.setFirstName(employee.getFirstName());
		existingemployee.setLastName(employee.getLastName());
		existingemployee.setEmail(employee.getEmail());
		employeeRepository.save(existingemployee);
		return existingemployee;
	}
	@Override
	public void deleteemployee(long id) 
	{   
		employeeRepository.findById(id).orElseThrow(()->new ResourceNotFound("Emplyee", "Id", id));
		employeeRepository.deleteById(id);
	}
}  
