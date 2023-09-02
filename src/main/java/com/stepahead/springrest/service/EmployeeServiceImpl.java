package com.stepahead.springrest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.stepahead.springrest.dao.EmployeeDAO;
import com.stepahead.springrest.entity.Employee;

import jakarta.transaction.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	//define employeeDAO field
	EmployeeDAO employeeDAO;
	
	//inject employeeDAO DAO using constructor injection
	public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}

	@Override
	public List<Employee> findAll() {
		return employeeDAO.findAll();
	}

	@Override
	public Employee findById(int theId) {
		return employeeDAO.findById(theId);
	}
	
	@Transactional
	@Override
	public Employee save(Employee theEmployee) {
		return employeeDAO.save(theEmployee);
	}
	
	@Transactional
	@Override
	public void deleteById(int theId) {
		employeeDAO.deleteById(theId);
	}

}
