package com.prasadch.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prasadch.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long>{

}
