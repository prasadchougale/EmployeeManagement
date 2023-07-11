package com.prasadch.service;

import java.util.List;

import com.prasadch.model.Employee;

public interface EmployeeService
{

  	  Employee saveemployee(Employee employee);//for save employee
  	  
	  public List<Employee> getallemployees();//for get allemployee list
	  
	  Employee getemployeeById(long id);//for gate employee by id
	  
	  Employee updateemployeebyid (Employee employee, long id); //for update employee by id
	 
	  void deleteemployee(long id);//for Delete emp
	  
 
	
}



