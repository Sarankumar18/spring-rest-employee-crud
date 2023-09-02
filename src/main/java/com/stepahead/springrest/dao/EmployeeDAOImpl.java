package com.stepahead.springrest.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.stepahead.springrest.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	// Define the field for entity manager
	private EntityManager entityManager;

	// Define the constructor
	public EmployeeDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Employee> findAll() {

		// cerate the query
		TypedQuery<Employee> query = entityManager.createQuery("FROM Employee", Employee.class);

		// Execute the query and get the results

		List<Employee> employees = query.getResultList();

		return employees;
	}

	@Override
	public Employee findById(int theId) {
		Employee myEmployee = entityManager.find(Employee.class, theId);
		return myEmployee;
	}

	@Override
	public Employee save(Employee theEmployee) {
		//save the Employee
		Employee myEmployee = entityManager.merge(theEmployee);
		
		//return the saved employee from the database
		return myEmployee;
	}

	@Override
	public void deleteById(int theId) {
		//find the employee by Id
		Employee theEmployee = entityManager.find(Employee.class, theId);
		
		//Delete the employee by ID
		entityManager.remove(theEmployee);
	}

}
