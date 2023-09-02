package com.stepahead.springrest.dao;

import java.util.List;

import com.stepahead.springrest.entity.Employee;

public interface EmployeeDAO {
	List<Employee> findAll();

	Employee findById(int theId);
	
	Employee save(Employee theEmployee);
	
	void deleteById(int theId);
}
